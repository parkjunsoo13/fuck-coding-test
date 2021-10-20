1107

문제
수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.

리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다. 
채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.

수빈이가 지금 이동하려고 하는 채널은 N이다. 어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오. 

수빈이가 지금 보고 있는 채널은 100번이다.

입력
첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)이 주어진다.  둘째 줄에는 고장난 버튼의 개수 M (0 ≤ M ≤ 10)이 주어진다. 
고장난 버튼이 있는 경우에는 셋째 줄에는 고장난 버튼이 주어지며, 같은 버튼이 여러 번 주어지는 경우는 없다.

출력
첫째 줄에 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지를 출력한다.



import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
xBtn = [] # 고장난 버튼을 입력받을 리스트 초기화
if M != 0: # 고장난 버튼이 있으면 고장난 버튼 입력 받음
    xBtn = list(map(str, input().split()))
btns = [str(i) for i in range(10) if str(i) not in xBtn] # 고장난 버튼을 제외한 버튼을 리스트에 삽입

answer = abs(N-100) # 현재 채널은 100

for ch in range(1000000): # brute-force N채널이 500000보다 위에서 -를 통해 채널변경 할수도 있으므로 1000000까지 탐색
    for idx, c in enumerate(str(ch)):
        if c not in btns: # 고장난 버튼이 있어 채널을 누를 수 없으면 break
            break
        elif idx == len(str(ch))-1: # 채널을 누를 수 있으면 현재 최솟값과 비교하여 최솟값 갱신
            answer = min(answer, abs(ch-N)+len(str(ch)))
            
print(answer)
