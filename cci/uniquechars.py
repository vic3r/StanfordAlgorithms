def has_unique_chars(word):
  mySet = set()
  for i in range(len(word)):
    if mySet.__contains__(word[i]):
      return False
    mySet.add(word[i])

  return True

def main():
  w = input()
  print(has_unique_chars(w))

if __name__ == "__main__":
  main()
