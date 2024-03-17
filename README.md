# 📜 B1L3-First-Project
> 화장품에 대해 잘 모르는 사람들을 위해 피부진단을 통해 화장품 추천을 하여 남녀노소 화장품 구매에 편리함을 느끼도록 개발
<br>개발 기간 : 2024.01.22 ~ 02.20
> <br>개발 인원 : 4명
<br>

## :books: 기술 스택
### 프론트엔드
  <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">  <img src="https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=css3&logoColor=white">
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white"> <img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">
  <img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white">
  <img src="https://img.shields.io/badge/thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white">
### 백엔드  
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white"> <img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white">
  <img src="https://img.shields.io/badge/apache tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=white">
- Spring Data JPA
- Spring Security
- AWS(Light sail)
- Apache Tomcat

### Skills
- Daum 주소 API
- KakaoMap API
- Full Calendar API(캘린더)
- PostOne API(결제)
 
## 🔎내가 맡은 역할 - Front

### 메인 페이지

- 사용자가 쉽게 카테고리에 접근 할 수 있도록 검색과 카테고리를 클릭하여 참가할수 있도록 구현

### 그룹 참가 페이지 

- 무료와 유료 모임을 구분하고, 6가지의 카테고리를 보고 모임을 선택할수 있도록 지원합니다

### 리뷰 페이지

- 간편하게 모임의 장에 관하여 점수를 부여하고 관련된 내용을 작성할수 있음습니다

### 로그인 페이지

- 회원가입을 통하여 로그인 할 수 있도록 되어있습니다.
- BackEnd에서 받아온 JWT토큰을 local Storage에 담아 정보를 사용

### 관리자 페이지

- 관리자가 간편하게 회원, 그룹, 사이트를 관리 할 수 있도록 되어있습니다.
- 모집인원, 모집기간이 끝난 모임은 확인할 수 있도록 표시되어있습니다.

## 🔍내가 맡은 역할 - Back

### 로그인 

- 로그인시 Spring Security JWT 토큰을 이용하여 회원의 정보를 프론트로 전달하여 사용 할 수 있도록 구현합니다.
- 로그인이 되어있지 않다면 모든 기능 사용 불가능

### 그룹 참가

- 로그인한 사용자의 권한에 맞게 그룹 참가 합니다
- 스케쥴 어노테이션을 사용하여 자정을 기준으로 당일 기준으로 30일 이전에 완료된 모임은 삭제합니다.
- 참가했던 그룹은 로직을 통해서 확인하여 알려줍니다.


### 모임 상세보기 및 신청 취소

- 사용자가 속한 모임에 대한 상세 정보를 제공하는 기능을 구현합니다.
- 사용자가 모임에 신청하고 이를 취소할 수 있도록 유연한 모임 참여 관리를 제공합니다.

### 내가 만든 모임 탈퇴

- 로그인한 사용자가 생성한 모임에서 탈퇴하는 기능을 구현합니다.
- 사용자가 만든 모임에서 나갈 수 있도록 탈퇴 로직을 처리합니다.

### 리뷰작성

- 모임기간이 끝난 모임에 한하여 모임장에 대한 리뷰 및 평가 점수를 줄수 있습니다.
- 모임원들이 평가한 점수로 인하여 모임장의 평균 점수가 80점이 넘으면 유료모임을 개설 할 수 있도록 로직 구현되어있습니다.

### 관리자 관리

- 회원들의 정보를 삭제 할 수있으며, 평가점수와 권한을 수정 할 수 있습니다.
- 개설되어있는 그룹에 한하여 그룹 삭제를 할 수 있습니다.
- 관련된 사이트를 그룹 참가하기 페이지에 추가 할 수 있으며, 삭제도 가능합니다.

### 계정 관련

- 이름과 이메일을 통하여 아이디를 찾을 수 있으며, 아이디는 앞 4글자까지 공개됩니다.
- 아이디, 이름, 이메일을 통하여 가입 당시 작성한 이메일로 임시비밀번호 발급합니다.



## :speaker: 프로젝트 주요 기능 

### Main
- 각 카테고리에 맞는 그룹리스트 이동
- 카테고리에 해당되는 그룹 검색
### 계정 관련
- 회원가입, 로그인, 로그아웃
- 아이디 찾기
- 임시 비밀번호 발급(이메일 발송)
- 개인 정보 수정
### 그룹 개설
- 권한에 따른 그룹 개설(유료 or 무료)
### 그룹 참가
- 카테고리에 맞는 그룹 검색
- 그룹 신청(유료모임 신청시 결제페이지 이동)
### 리뷰 
- 리뷰 검색 및 작성
### 일정 관리 
- 캘린더를 통한 일정 CRUD
- 내가 가입한 모임 상세보기
- 신청한 모임, 개설한 모임 탈퇴
### 관리자 페이지
- 모든 회원에 관한 수정과 삭제 가능
- 그룹 삭제 및 사이트 추가

## 💻화면
- 그룹개설<br>

![20240303_162936](https://github.com/alsrl2275/alsrl2275/assets/142866976/99e24c14-6bb8-4b94-829a-a8abccaf8132)
![20240303_163722](https://github.com/alsrl2275/alsrl2275/assets/142866976/4ddc9d7e-788f-4d1c-aaef-9ef768167182)<br>

- 일정관리<br>

![20240303_163409](https://github.com/alsrl2275/alsrl2275/assets/142866976/3552dc58-c310-4959-9937-92a034f19d68)<br>

![20240303_163427](https://github.com/alsrl2275/alsrl2275/assets/142866976/3927c3cf-e75c-4322-8f27-7664654331ae)<br>

![20240303_164230](https://github.com/alsrl2275/alsrl2275/assets/142866976/26110683-011d-4f18-9b65-aba945376ca5)<br>

![20240303_164307](https://github.com/alsrl2275/alsrl2275/assets/142866976/7994dd10-e34d-4aed-becc-74d942f1dff4)<br>

![20240303_164324](https://github.com/alsrl2275/alsrl2275/assets/142866976/2740c261-7839-4b78-913e-f99bfb7fc6f1)

- 유로모임 신청 시 결제화면 <br>

![20240303_164619](https://github.com/alsrl2275/alsrl2275/assets/142866976/ea011d62-484b-4d91-a35a-628eed49ef8e)

