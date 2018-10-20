logs = []

def record(order_id):
  logs.append(order_id)

def get_last(i):
  if i > len(logs):
    return None
  
  return logs[i-1]


def main():
  record(1)
  record(4)
  record(7)
  record(8)
  print(get_last(4))

if __name__ == "__main__":
  main()
