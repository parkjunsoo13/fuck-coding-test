1074

문제
한수는 크기가 2N × 2N인 2차원 배열을 Z모양으로 탐색하려고 한다. 예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.

N > 1인 경우, 배열을 크기가 2N-1 × 2N-1로 4등분 한 후에 재귀적으로 순서대로 방문한다.

다음 예는 22 × 22 크기의 배열을 방문한 순서이다.

N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.

다음은 N=3일 때의 예이다.

입력
첫째 줄에 정수 N, r, c가 주어진다.

출력
r행 c열을 몇 번째로 방문했는지 출력한다.



N, r, c = map(int,input().split())
dq = [] # divide and conquer 주어진 행과 열이 어느 사분면에 위치하는지 삽입하는 리스트
answer = 0

for i in range(N,0,-1): # 2**N x 2**N차원 배열이므로 해당 배열을 1,2,3,4 분면으로 나누어 어느 사분면에 위치하는지 리스트에 기록
    quad = 2**i//2 # 사분면을 계산할때마다 기준 위치가 달라지므로 r, c 위치 재조정
    if quad <= r and quad <= c: 
        dq.append(4)
        r -= quad
        c -= quad
    elif quad <= r and quad > c: 
        dq.append(3)
        r -= quad
    elif quad > r and quad <= c: 
        dq.append(2)
        c -= quad
    elif quad > r and quad > c: 
        dq.append(1)

for q in dq:
    answer += (4**(N-1))*(q-1) # N이 커질때마다 4제곱씩 증가함 그 값에 사분면 값을 곱함
    N -= 1

print(answer)
