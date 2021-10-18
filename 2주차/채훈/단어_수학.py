1339

문제
민식이는 수학학원에서 단어 수학 문제를 푸는 숙제를 받았다.

단어 수학 문제는 N개의 단어로 이루어져 있으며, 각 단어는 알파벳 대문자로만 이루어져 있다. 이때, 각 알파벳 대문자를 0부터 9까지의 숫자 중 하나로 바꿔서 N개의 수를 합하는 문제이다. 같은 알파벳은 같은 숫자로 바꿔야 하며, 두 개 이상의 알파벳이 같은 숫자로 바뀌어지면 안 된다.

예를 들어, GCF + ACDEB를 계산한다고 할 때, A = 9, B = 4, C = 8, D = 6, E = 5, F = 3, G = 7로 결정한다면, 두 수의 합은 99437이 되어서 최대가 될 것이다.

N개의 단어가 주어졌을 때, 그 수의 합을 최대로 만드는 프로그램을 작성하시오.

입력
첫째 줄에 단어의 개수 N(1 ≤ N ≤ 10)이 주어진다. 둘째 줄부터 N개의 줄에 단어가 한 줄에 하나씩 주어진다. 단어는 알파벳 대문자로만 이루어져있다. 모든 단어에 포함되어 있는 알파벳은 최대 10개이고, 수의 최대 길이는 8이다. 서로 다른 문자는 서로 다른 숫자를 나타낸다.

출력
첫째 줄에 주어진 단어의 합의 최댓값을 출력한다.



N = int(input())
words = [input() for _ in range(N)] # 단어를 저장할 리스트

coef = dict() # 알파벳을 자리 수에 맞게 계수를 추가해줄 딕셔너리
for word in words: # 모든 단어에 대해서
    for idx, c in enumerate(word[::-1]): # 알파벳이 나온 자릿 수만큼 10의 제곱수를 더해줌
        if c in coef: coef[c] += 10**idx
        else: coef[c] = 10**idx
            
coef = sorted(coef.items() , key=lambda x:x[1], reverse=True) # 내림차순 정렬

aNum = dict() # 알파벳에 수를 삽입할 딕셔너리
high = 9
for i in coef: # 정렬되 있으므로 9부터 차례로 수를 삽입
    aNum[i[0]] = high
    high -= 1

answer = 0
for word in words: # 모든 단어에 대해서
    w = ''
    for c in word:
        w += str(aNum[c]) # 각 알파벳에 해당하는 수로 변환
    answer += int(w) # answer에 더함
    
print(answer)
