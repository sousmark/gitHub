# matrice = [[0, 5.1, 8.3, 13.3, 24.2, 5.1, 8.3, 13.3, 24.2, 1, 1],
#             [4.4,0,3.8,6.7,21.1,5.1,8.3,13.3,24.2,1,1],
#             [7.1,3.4,0,3.8,23.8,5.1,8.3,13.3,24.2,1,1], 
#             [9.7,6,3.6,0,27.2,5.1,8.3,13.3,24.2,1,1],
#             [22.4,22,25.2,24.2,0,5.1,8.3,13.3,24.2,1,1],
#             [22.4,22,25.2,24.2,1,0,8.3,13.3,24.2,1,1],
#             [22.4,22,25.2,24.2,2,5.1,0,13.3,24.2,1,1],
#             [22.4,22,25.2,24.2,3,5.1,8.3,0,24.2,1,1],
#             [22.4,22,25.2,24.2,4,5.1,8.3,13.3,0,1,1],
#             [22.4,22,25.2,24.2,5,5.1,8.3,13.3,24.2,0,1],
#             [22.4,22,25.2,24.2,6,5.1,8.3,13.3,24.2,1,0]]

matrice =   [[0, 8920, 282, 4512],
            [8589, 0, 7836, 7551],
            [1159, 8637, 0, 4229], 
            [4826, 8196, 4188, 0]]


indexPlusCourtChemin = [0]

def plusCourtChemin(villeDepart):
    # if(villeDepart == len(matrice[villeDepart])-1):
    #     plusCourtChemin = matrice[villeDepart][0]
    # else:
    #     plusCourtChemin = matrice[villeDepart][villeDepart+1]

    
    flag=True
    for i in range(len(matrice[villeDepart])):
        if(villeDepart != i and i not in indexPlusCourtChemin):
            if(flag):
                plusCourtChemin = matrice[villeDepart][i]
                checkpointIndex = i
                flag=False
            if(matrice[villeDepart][i] < plusCourtChemin):
                plusCourtChemin = matrice[villeDepart][i]
                checkpointIndex = i

    indexPlusCourtChemin.append(checkpointIndex)
    print('[', checkpointIndex, '],[', plusCourtChemin, ']')

def algo1():
    plusCourtChemin(0)
    while(len(indexPlusCourtChemin) < len(matrice)):
        plusCourtChemin(indexPlusCourtChemin[len(indexPlusCourtChemin)-1])
    return indexPlusCourtChemin



import wrapper
from flask import Flask, jsonify, request
 
app = Flask(__name__)

@app.route('/api/algo1/', methods=['GET'])
def algo1():
result = wrapper.get_all_users()
if result:
return jsonify(status="True",
result= [
{"nom":user.nom,
"prenom":user.prenom,
"email":user.email,
"ville": user.ville,
"telephone": user.telephone} for user in result.all() ])
return jsonify(status="False")