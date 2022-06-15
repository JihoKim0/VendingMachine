\n# VendingMachine
2020 자바 강의 텀프로젝트 - 자판기 프로그램\

<기본 기능(과제의 요구사항)>\
 1) 판매 음료는 5가지(물-450원, 커피-500원, 이온 음료-550원, 700원-고급 커피, 탄산음료-750원), 각 음료의 기본재고는 3개\
 2) 음료 개수에 따른 품절 표시 기능\
 3) 화폐 입력 제한 기능\
  ① 입력 가능한 화폐 단위는 10원, 50원, 100원, 500원, 1,000원\
  ② 지폐로 받을 수 있는 금액의 상한선은 3,000원\
  ③ 지폐와 동전을 포함하여 총 5,000원을 초과하여 입력받을 수 없음\
 4) 거스름돈 기능(각 동전별로 5개가 기본값, 거스름돈 반환 혹은 음료 판매에 따른 동전의 가감 구현), 화폐 반환 기능\
 5) 관리자 메뉴(재고 보충 메뉴, 수금 메뉴, 비밀번호 변경 메뉴)\
  ① 특정 버튼 조합(반환버튼 연속 5번) 입력 시 실행, 비밀번호 확인을 통해 관리자 메뉴에 접근 가능하도록 하기(비밀번호는 특수문자(!,*,&,#) 및 숫자가 하나 이상 포함된 8자리 이상, 비밀번호 입력 시 *로 표시, 입력 실패 시 조건 제시, 비밀번호는 필요하면 언제든 변경 가능해야함. 초기 비밀번호는 20194054!)\
  ② 비밀번호 입력 성공 시 관리자메뉴로 이동
  ③ 각 음료의 재고 보충 기능  ④ 현재 자판기 내의 화폐 현황 파악 기능
  ⑤ “수금 메뉴” 선택 시 해당 금액 수금 기능(반환을 위한 최소한의 화폐(각 동전별로 5개)는 남겨두어야 함)
  ⑥ 현재 자판기 내의 화폐 현황을 손쉽게 파악 가능해야함
  ⑦ 각 음료의 판매 가격, 판매 이름 변경 기능
  ⑧ 비밀번호 변경 가능
