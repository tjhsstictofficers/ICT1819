def main():
    check = input()
    count = 0
    for i in range (0, len(check)):
        for j in range(i + 1, len(check)):
            if check[i] != "_" and check[j] != "_":
                if int(check[i]) > int(check[j]):
                    count = count + 1
    if count % 2 == 0:
      print("YES")
    else:
      print("NO")

if __name__ == '__main__':
    main()
