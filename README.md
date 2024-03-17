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
- Querydsl
- Spring Security
- Thymeleaf
 
## 🔎내가 맡은 역할 - Front

### 로그인 / 아이디,비밀번호 찾기

- 사이트 내 ID로그인과, 소셜(카카오)로그인을 구현 하였습니다.

### 회원가입

- 사이트 내 회원가입과, 소셜(카카오) 간편 회원가입을 구현하였습니다.

### 피부진단

- 저희가 지정한 질문을 통해 화장품을 추천하는 페이지 입니다.

### footer map APi

- 회사 위치기반으로 지도로 위치 정보 공유

### 관리자 페이지

- 상품, 회원, 취소/반품 관리하는 페이지 입니다.

## 🔍내가 맡은 역할 - Back

### 로그인

- 프론트에서 넘어온 정보를 가지고 데이터베이스와 연결하여 기존의 정보가 있는지 확인을 하고 
  정보가 있다면 로그인, 없다면 회원가입 페이지로 이동시키도록 구현합니다.

### 아이디,비밀번호 찾기

- 프론트에서 넘어온 정보를 가지고 데이터베이스와 연결하여 기존의 정보가 있는지 확인을 하고
  정보가 있다면 아이디는 전체 공개를 하여 정보를 알려주고,
  비밀번호는 재설정 할 수 있도록 구현합니다.

### 회원가입

- 정규식 표현을 사용하여 회원가입 할 수 있도록 구현합니다.

### 피부진단

- 아직 알고리즘을 공부 못하였을 때라 if문을 가지고 여러가지 질문의 공통된 답을 찾아
  데이터베이스에 저장되어있는 화장품중에 일치하는것을 출력되도록 구현합니다.

### footer map APi

- 카카오톡 developer을 통하여 지정한 위치기반으로 지도에 표출되도록 표현

### 관리자 페이지
## CRUD 관련
- 제품, 회원관리 기능인 추가, 수정, 삭제 등의 작업을 구현합니다.
## 취소/반품
- CURD로 삭제와 수정을 구현하여, 승인을 해주었을 경우 작성한 유저의 상태에서도 변하도록 구현하였습니다.

## :speaker: 프로젝트 주요 기능 

### Main
- 등록 기준 최신순으로 상품을 보여줍니다.
- 리뷰점수 기준으로하여 최신순으로 리뷰를 보여줍니다.
### 계정 관련
- 회원가입, 로그인, 로그아웃
- 아이디, 비밀번호 찾기
- 개인 정보 수정
### 전제품
- 등록된 상품을 볼 수 있으며, 구매/장바구니 담기
### TEST
- 6가지의 질문에 답변을 하여 화장품 추천
### 리뷰 
- 리뷰 작성, 검색, 수정 등
### COMMUNITY
## Q&A
- 관리자와의 소통을 위한 게시판 CRUD
## 자주하는 질문
- 관리자가 지정해놓은 top10 질문
## 취소/반품
- 구매한 제품을 취소/반품 신청 및 내역 확인
### 관리자 페이지
- 회원,상품,취소/반품 수정, 추가, 삭제

## 💻화면
- 전제품<br>
![semi1](https://github.com/juseungBaek/first-project/assets/151498425/db314677-62ae-468e-890f-9fbf8ea97cfb)
![semi2](https://github.com/juseungBaek/first-project/assets/151498425/e2d0dc31-8cf5-4d39-9d02-c5c189bfe1fc)

- TEST<br>
![semi1](https://github.com/juseungBaek/first-project/assets/151498425/8f8c15d4-cdfb-4417-8480-ac8488c9d43f)
![semi1](https://github.com/juseungBaek/first-project/assets/151498425/7bcba29f-3e93-4827-9f59-4ac812d430f4)

- REVIEW <br>
![semi1](https://github.com/juseungBaek/first-project/assets/151498425/4b616d39-470b-4b23-870b-9aa4fb5e5703)
![semi1](https://github.com/juseungBaek/first-project/assets/151498425/4badcecc-7571-441d-9171-7193500fdd79)

- COMMUNITY <br>
![semi1](https://github.com/juseungBaek/first-project/assets/151498425/505d318a-23c5-49e7-8b64-f7f37b4387c8)
![semi1](https://github.com/juseungBaek/first-project/assets/151498425/8a4eb36d-e3e3-48ff-b69c-57e1a6cad8fc)
![semi1](https://github.com/juseungBaek/first-project/assets/151498425/5adf5cee-7b2a-4cd7-9ca9-d10619fc8b3b)

- 관리자<br>
![semi1](https://github.com/juseungBaek/first-project/assets/151498425/0911c0f9-4052-461f-ae14-844c89f4dd28)
![semi1](https://github.com/juseungBaek/first-project/assets/151498425/0064ecf3-1c79-49ca-bf90-2ce60619d533)
![semi1](https://github.com/juseungBaek/first-project/assets/151498425/10016a52-88c0-4547-a937-febc3a50538a)
![semi1](https://github.com/juseungBaek/first-project/assets/151498425/76584730-2eec-4f24-92fc-836bcd10237e)






