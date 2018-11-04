def levenshtein(w1, w2):
  x = len(w1) + 1
  y = len(w2) + 1

  matrix = [[-1 for i in range(x)] for j in range(y)]
  
  for i in range (x):
    matrix[0][i] = i

  for j in range (y):
    matrix[j][0] = j

  for i in range(1, y):
    for j in range(1, x):
      if (w1[j-1] == w2[i-1]):
        matrix[i][j] = matrix[i-1][j-1]
      else:
        matrix[i][j] = min(
           matrix[i-1][j]+1, # Add
           matrix[i][j-1]+1, # Remove
           matrix[i-1][j-1]+1 #Replace
          )
  
  return matrix[-1][-1]

def main():
  print(levenshtein("kitten", "sitting"))

if __name__=="__main__":
  main()
