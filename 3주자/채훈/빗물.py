14719

문제
2차원 세계에 블록이 쌓여있다. 비가 오면 블록 사이에 빗물이 고인다.



비는 충분히 많이 온다. 고이는 빗물의 총량은 얼마일까?

입력
첫 번째 줄에는 2차원 세계의 세로 길이 H과 2차원 세계의 가로 길이 W가 주어진다. (1 ≤ H, W ≤ 500)

두 번째 줄에는 블록이 쌓인 높이를 의미하는 0이상 H이하의 정수가 2차원 세계의 맨 왼쪽 위치부터 차례대로 W개 주어진다.

따라서 블록 내부의 빈 공간이 생길 수 없다. 또 2차원 세계의 바닥은 항상 막혀있다고 가정하여도 좋다.

출력
2차원 세계에서는 한 칸의 용량은 1이다. 고이는 빗물의 총량을 출력하여라.

빗물이 전혀 고이지 않을 경우 0을 출력하여라.



import sys
input = sys.stdin.readline

H, W = map(int, input().split())
blocks = list(map(int, input().split()))

left = 0
right = W-1
max_left = blocks[left]
max_right = blocks[right]

answer = 0

while left < right:
    max_left = max(max_left, blocks[left]) # 왼쪽 최댓값 갱신
    max_right = max(max_right, blocks[right]) # 오른쪽 최댓값 갱신
    
    if max_right >= max_left: # 오른쪽 최댓값이 더 크다면 왼쪽에서부터 고이는 물의 높이를 계속 세어 나간다.
        answer += max_left - blocks[left]
        left += 1
    else: # 왼쪽 최댓값이 더 크다면 오른쪽에서부터 고이는 물의 높이를 계속 세어 나간다.
        answer += max_right - blocks[right]
        right -= 1

print(answer) # 결과 출력
