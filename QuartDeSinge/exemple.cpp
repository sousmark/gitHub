#include <iostream>
#include <fstream> // pour ifstream
#include <iomanip> // pour setw

using namespace std;

typedef struct Joueur Joueur;
struct Joueur
{
	char type;
	bool tour;
	int quart_de_singe;
};

void lancer_partie(Joueur joueurs[], int nb_joueurs);
void tour_humain(char *mot, Joueur joueurs[], int *joueur_actuel, int nb_joueurs);
void tour_robot(char *mot, Joueur joueurs[], int *joueur_actuel, int nb_joueur);
bool existe_dictionnaire(char *mot);
void fin_de_manche(char *mot, Joueur joueurs[], int nb_joueurs);
void interroger(char *mot, Joueur joueurs[], int *joueur_actuel, int nb_joueur);
void abandonner(char *mot, Joueur joueurs[], int joueur_actuel, int nb_joueurs);
void recherche_dictionnaire(char *mot, char *c);

/*
   argc -> nombre de paramètres sur la ligne de commande (+ 1)
   argv -> paramètres de la ligne de commande
		   (argv[0] : la cde, argv[1] : le 1er paramètre, etc)
*/
int main(int argc, const char *argv[])
{
	// parametre sur la ligne de commande
	if (argc >= 2)
		cout << "le 1er parametre est '" << argv[1] << "'" << endl;
	else
		cout << "il n'y a pas de parametre" << endl;

	Joueur joueurs[strlen(argv[1])];
	int i;

	for (i = 0; i < strlen(argv[1]); i++)
	{
		joueurs[i].type = argv[1][i];
		joueurs[i].tour = false;
		joueurs[i].quart_de_singe = 0;
	}

	joueurs[0].tour = true;

	lancer_partie(joueurs, i);
	return 0;
}

void lancer_partie(Joueur joueurs[], int nb_joueurs)
{
	char mot[26] = "";
	int i = 0;

	while (true)
	{
		cout << (i + 1) << joueurs[i].type << ", (" << mot << ") > ";
		if (joueurs[i].type == 'H')
			tour_humain(mot, joueurs, &i, nb_joueurs);
		else
			tour_robot(mot, joueurs, &i, nb_joueurs);

		if (existe_dictionnaire(mot))
		{
			cout << "le mot " << mot << " existe, " << (i + 1) << joueurs[i].type << " prend un quart de singe" << endl;
			joueurs[i].quart_de_singe++;
			fin_de_manche(mot, joueurs, nb_joueurs);
			i--;
		}
		if (i == nb_joueurs - 1)
			i = 0;
		else
			i++;
	}
}

void tour_humain(char *mot, Joueur joueurs[], int *joueur_actuel, int nb_joueurs)
{
	char c;
	cin >> c;

	if (c == '?')
		interroger(mot, joueurs, joueur_actuel, nb_joueurs);
	else if (c == '!')
	{
		abandonner(mot, joueurs, *joueur_actuel, nb_joueurs);
		*joueur_actuel -= 1;
	}
	else
	{
		size_t n = strlen(mot);
		mot[n] = toupper(c);
		mot[n + 1] = '\0';
	}
}

bool existe_dictionnaire(char *mot)
{
	// lecture du dictionnaire mot à mot
	ifstream in("ods4.txt"); // on ouvre le fichier

	if (!in)
	{
		cout << "le dictionnaire n'a pu etre ouvert" << endl;
		return 2;
	}

	const int MAX = 26;
	char s[MAX];
	in >> setw(MAX) >> s; // on essaye de lire le premier mot
	if (strcmp(mot, s) == 0)
	{
		return true;
	}
	while (in)
	{
		in >> setw(MAX) >> s; // on essaye de lire le mot suivant
		if (strcmp(mot, s) == 0)
			return true;
	}

	in.close(); // on ferme le fichier
	return false;
}

void fin_de_manche(char *mot, Joueur joueurs[], int nb_joueurs)
{
	mot[0] = '\0';
	for (int i = 0; i < nb_joueurs; i++)
	{
		if (i != 0)
			cout << " ; ";
		cout << (i + 1) << joueurs[i].type << " : " << (float)joueurs[i].quart_de_singe / 4;
	}
	cout << endl;

	for (int i = 0; i < nb_joueurs; i++)
	{
		if (joueurs[i].quart_de_singe == 4)
		{
			cout << "La partie est finie" << endl;
			exit(EXIT_SUCCESS);
		}
	}
}

void tour_robot(char *mot, Joueur joueurs[], int *joueur_actuel, int nb_joueur)
{
	size_t n = strlen(mot);
	char carac_interdit;
	// cout << "BONJOUR" << joueur_actuel << endl;

	// lecture du dictionnaire mot à mot
	ifstream in("ods4.txt"); // on ouvre le fichier

	if (!in)
	{
		cout << "le dictionnaire n'a pu etre ouvert" << endl;
		exit(2);
	}

	const int MAX = 26;
	char s[MAX];
	int i;
	bool flag = true;
	in >> setw(MAX) >> s; // on essaye de lire le premier mot
	for (i = 0; i < n; i++)
	{
		if (mot[i] != s[i])
			break;
	}

	if (s[i + 1] == '\0')
		carac_interdit = s[i];

	if (i == n && strlen(s) > strlen(mot) + 1 && s[i] != carac_interdit)
		flag = false;

	while (in && flag)
	{
		in >> setw(MAX) >> s; // on essaye de lire le mot suivant
		for (i = 0; i < strlen(s); i++)
		{
			if (mot[i] != s[i])
				break;
		}

		if (s[i + 1] == '\0')
		{
			carac_interdit = s[i];
		}

		if (i == n && strlen(s) > strlen(mot) + 1 && s[i] != carac_interdit)
			flag = false;
	}
	in.close(); // on ferme le fichier

	if (flag)
	{
		cout << '?' << endl;
		interroger(mot, joueurs, joueur_actuel, nb_joueur);
	}
	else
	{
		cout << s[i] << endl;
		mot[n] = s[i];
		mot[n + 1] = '\0';
	}
}

void interroger(char *mot, Joueur joueurs[], int *joueur_actuel, int nb_joueur)
{
	int joueur_interroge;
	char c[26];

	if (*joueur_actuel - 1 < 0)
		joueur_interroge = nb_joueur - 1;
	else
		joueur_interroge = *joueur_actuel - 1;

	cout << (joueur_interroge + 1) << joueurs[joueur_interroge].type << ", saisir le mot > ";

	if (joueurs[joueur_interroge].type == 'R')
	{
		recherche_dictionnaire(mot, c);
		cout << c << endl;
	}
	else
	{
		cin >> c;
	}

	if (existe_dictionnaire(c))
	{
		cout << "le mot " << c << " existe, " << (*joueur_actuel + 1) << joueurs[*joueur_actuel].type << " prend un quart de singe" << endl;
		joueurs[*joueur_actuel].quart_de_singe++;
		*joueur_actuel = joueur_interroge;
	}
	else
	{
		cout << "le mot " << c << " n\'existe pas, " << (joueur_interroge + 1) << joueurs[joueur_interroge].type << " prend un quart de singe" << endl;
		joueurs[joueur_interroge].quart_de_singe++;
	}

	fin_de_manche(mot, joueurs, nb_joueur);
}

void abandonner(char *mot, Joueur joueurs[], int joueur_actuel, int nb_joueurs)
{
	cout << (joueur_actuel + 1) << joueurs[joueur_actuel].type << " prend un quart de singe" << endl;
	joueurs[joueur_actuel].quart_de_singe++;
	fin_de_manche(mot, joueurs, nb_joueurs);
}

void recherche_dictionnaire(char *mot, char *c)
{
	ifstream in("ods4.txt"); // on ouvre le fichier

	if (!in)
	{
		cout << "le dictionnaire n'a pu etre ouvert" << endl;
		exit(2);
	}

	const int MAX = 26;
	char s[MAX];
	int i;

	in >> setw(MAX) >> s; // on essaye de lire le premier mot

	for (i = 0; i < strlen(s); i++)
	{
		if (mot[i] != s[i])
			break;
	}

	if (i == strlen(mot))
	{
		strcpy(c, s);
		return;
	}

	while (in)
	{
		in >> setw(MAX) >> s; // on essaye de lire le mot suivant
		for (i = 0; i < strlen(s); i++)
		{
			if (mot[i] != s[i])
				break;
		}
		if (i == strlen(mot))
		{
			strcpy(c, s);
			return;
		}
	}

	in.close();
}