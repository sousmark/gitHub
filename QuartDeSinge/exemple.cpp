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


/* 
   argc -> nombre de paramètres sur la ligne de commande (+ 1)
   argv -> paramètres de la ligne de commande 
           (argv[0] : la cde, argv[1] : le 1er paramètre, etc)
*/
int main(int argc, const char* argv[]) {
	// parametre sur la ligne de commande
	if (argc >= 2)
		cout << "le 1er parametre est '" << argv[1] << "'" << endl;
	else
		cout << "il n'y a pas de parametre" << endl;

	Joueur joueurs[strlen(argv[1])];

	for (int i = 0; i < strlen(argv[1]); i++)
	{
		
		joueurs[i].type = argv[1][i];
		joueurs[i].tour = false;
		joueurs[i].quart_de_singe = 0;
	}

	// cout << joueurs[3].quart_de_singe << endl;
	// cout << joueurs[3].type << endl;
	// cout << joueurs[3].tour << endl;
	
	joueurs[0].tour = true;

	lancer_partie(joueurs);

	// lecture du dictionnaire mot à mot
	ifstream in("ods4.txt"); // on ouvre le fichier
	if (!in) {
		cout << "le dictionnaire n'a pu etre ouvert" << endl;
		return 2;
	}

	int nb = 0, longueur = 0;
	const int MAX = 26;
	char s[MAX];
	in >> setw(MAX) >> s; // on essaye de lire le premier mot
	while (in) {
		++nb; // ça s'est bien passé, on le compte
		longueur += strlen(s); // et on accumule sa longueur
		in >> setw(MAX) >> s; // on essaye de lire le mot suivant
	}
	in.close(); // on ferme le fichier
	cout << nb << " mots de " << (float)longueur / nb << " car. en moyenne" << endl;

	return 0;
}


int lancer_partie(Joueur joueurs[]) {

}