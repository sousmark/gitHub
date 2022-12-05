
# -*- coding: utf-8 -*-

# Matrice des distances entre villes distance[1][2] est la distance entre la
# ville d'indice 1 ("Bordeau") et la ville d'indice 2 ("Brest").
from itertools import permutations 

distance = [[0,5.1,8.3,13.3,24.2,5.1,8.3,13.3,24.2,1,1],
            [4.4,0,3.8,6.7,21.1,5.1,8.3,13.3,24.2,1,1],
            [7.1,3.4,0,3.8,23.8,5.1,8.3,13.3,24.2,1,1], 
            [9.7,6,3.6,0,27.2,5.1,8.3,13.3,24.2,1,1],
            [22.4,22,25.2,24.2,0,5.1,8.3,13.3,24.2,1,1],
            [22.4,22,25.2,24.2,1,0,8.3,13.3,24.2,1,1],
            [22.4,22,25.2,24.2,2,5.1,0,13.3,24.2,1,1],
            [22.4,22,25.2,24.2,3,5.1,8.3,0,24.2,1,1],
            [22.4,22,25.2,24.2,4,5.1,8.3,13.3,0,1,1],
            [22.4,22,25.2,24.2,5,5.1,8.3,13.3,24.2,0,1],
            [22.4,22,25.2,24.2,6,5.1,8.3,13.3,24.2,1,0]]


# Nom des villes. On travailler avec les indices.
villes = ["ESME","Bercy","Pantheon","Invalides","Kebab","Marseille","Toulon","Bordeaux","Nice","Brest","ZOZ"]

def prochaine_ville(indice_ville_actuelle,indice_villes_visitees) :
    #""" La fonction donne l'indice de la ville la plus proche de celle d'indice actuel
    #et qui n'a pas �t� visit�e. """
    mini = 1000000000
    indice_mini = -1
    for i in range(len(distance)) :
        if indice_villes_visitees[i] == False :
            if distance[indice_ville_actuelle][i] < mini :
                mini = distance[indice_ville_actuelle][i]
          
                indice = i
    return indice

def parcourt_chemin(chemin) :
    #Fonction qui affiche le trajet final du voyageur.
    trajet =""
    for numero_ville in chemin:
        trajet += villes[numero_ville] + " - "
    trajet += villes[chemin[0]]
    return trajet

def calcul_distance(chemin) :
    #""" Fonction qui calcul la distance du trajet """
    distance_trajet = 0
    for i in range(len(chemin)-1) :
        distance_trajet += distance[chemin[i]][chemin[i+1]]
    distance_trajet += distance[chemin[-1]][chemin[0]]
    return distance_trajet

def permutation(list1):  
   # If the length of list=0 no permuataions possible 
   if len(list1) == 0:  
       return []  
   # If the length of list=1, return that element 
   if len(list1) == 1:  
       return [list1]  
   l = []  
   for i in range(len(list1)):  
       m = list1[i]  
      # Extract list1[i] or m from the list. remlist1 is  
      # remaining list  
       remlist1 = list1[:i] + list1[i+1:]  
      # Generating all permutations where m is first  
      # element  
       for p in permutation(remlist1):  
            l.append([m] + p)  
   return l 

def glouton(ville_debut):
    #""" La fonction donne le chemin a suivre du voyageur de commerce sous forme d'un tableau d'indice."""
    indice_villes_visitees = [False] * (len(villes)+1) # Au d�part les villes ne sont pas visit�es
    #tableau_combinaison =[[indice_villes_visitees] * (len(villes)+1)]
    #print(tableau_combinaison)
    chemin = [0]* (len(distance))   # Le chemin du voyageur au d�part il est est vide.

    indice_ville_actuelle = villes.index(ville_debut) # On trouve l'indice de la ville
    indice_villes_visitees[indice_ville_actuelle] = True #On dit que la ville est vist�e.
    chemin[0] = indice_ville_actuelle
    #chemin_combinaison=[]
    #chemin_combinaison.append(chemin)
    for i in range(1,len(distance)) :
        indice_prochaine_ville= prochaine_ville(indice_ville_actuelle,indice_villes_visitees)
        chemin[i] = indice_prochaine_ville
        indice_ville_actuelle = indice_prochaine_ville
        indice_villes_visitees[indice_ville_actuelle] = True # La ville est visit�e elle ne peut plus �tre prise.
    list = permutation(chemin[1:len(chemin)])
    list_parcours_distance= []
    for x in list:
        x.insert(0,0)
        list_parcours_distance.append([parcourt_chemin(x),calcul_distance(x)])
    
    #print(list_parcours_distance)
    #chemin_combinaison.append(chemin)
    mini =1000000000000
    for x in range(len(list_parcours_distance)):

       if list_parcours_distance[x][1]<mini:
           shortest_parcours = x
           mini= shortest_parcours
    print(len(list_parcours_distance))
    print("Le parcours le plus court est : " , list_parcours_distance[shortest_parcours])

glouton("ESME")