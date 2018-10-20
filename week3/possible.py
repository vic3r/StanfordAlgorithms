def ways_helper(number, k, memo):
  if k == 0:
     return 1
  # Check [0]
  s = len(number) - k
  if s == '0':
    return 0
  # Memoization if is not stored
  if memo[k] != None:
    return memo[k]
  # Check for the first element
  result = ways_helper(number, k-1, memo)
  if k >= 2 and int(number[s:s+2]) <= 26:
    # Check the first 2 elements
    result += ways_helper(number, k-2, memo) 
  
  # Store in memo
  memo[k] = result
  return result

def ways(number):
  memo = [None] * (len(number)+1)
  return ways_helper(number, len(number), memo)

print(ways("011111"))
