1038

문제
음이 아닌 정수 X의 자릿수가 가장 큰 자릿수부터 작은 자릿수까지 감소한다면, 그 수를 감소하는 수라고 한다. 
예를 들어, 321과 950은 감소하는 수지만, 322와 958은 아니다. N번째 감소하는 수를 출력하는 프로그램을 작성하시오. 0은 0번째 감소하는 수이고, 1은 1번째 감소하는 수이다. 
만약 N번째 감소하는 수가 없다면 -1을 출력한다.

입력
첫째 줄에 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 N번째 감소하는 수를 출력한다.



from itertools import combinations

N = int(input())

numbers = []

for i in range(1, 11): # 
    for comb in combinations(range(0, 10), i): # 1자리 ~ 10자리까지 모든 조합을 뽑아냄
        comb = list(comb) 
        comb.sort(reverse=True) # 역으로 정렬하면 감소하는 수가 됨
        numbers.append(int(''.join(map(str, comb)))) # int 형으로 변환하여 numbers에 삽입

numbers.sort()

try:
    print(numbers[N]) # 입력받은 인덱스의 감소하는 수를 출력
except:
    print(-1) # 인덱스 에러가 날 시 N번째 감소하는 수가 없는 것이므로 -1 출력
