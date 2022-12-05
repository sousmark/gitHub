def incremente(nombre, max):
    if nombre >= max-1:
        return 0
    return nombre+1
            #A              #B              #C              #D
tableau = [[-1, 1, 2, 3], [4, -1, 5, 6], [7, 8, -1, 9], [10, 11, 12, -1]]

print(tableau)

total = 0
checkpoint = 0

total = tableau[0][1] + tableau[1][2] + tableau[2][3] + tableau[3][0] #ABCD
total = tableau[0][1] + tableau[1][3] + tableau[3][2] + tableau[2][0] #ABDC

total = tableau[0][2] + tableau[2][1] + tableau[1][3] + tableau[3][0] #ACBD
total = tableau[0][2] + tableau[2][3] + tableau[3][1] + tableau[1][0] #ACDB

total = tableau[0][3] + tableau[3][1] + tableau[1][2] + tableau[2][0] #ADBC
total = tableau[0][3] + tableau[3][2] + tableau[2][1] + tableau[1][0] #ADCB

total = 0
checkpoint = 0
for i in range(len(tableau)-1):
    for j in range(len(tableau)):
        # total+=tableau[i][checkpoint]
        print('[', i, '],[', checkpoint, ']')
        checkpoint = incremente(checkpoint, len(tableau[0]))
    print()