def encryptWord(w):
  if (len(w) == 0):
    return ""
    
  letters = list(w)
  prevChar = letters[0]
  builder = ""
  count = 1
  for i in range (1, len(w)):
    if(prevChar == letters[i]):
      count+=1
    else:
      builder+=(prevChar+ str(count))
      count = 1
      prevChar = letters[i]

  builder+=(prevChar+ str(count))
  return builder

def main():
  print(encryptWord("A"))

if __name__=="__main__":
  main()
