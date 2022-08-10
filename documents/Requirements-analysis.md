## 📝 요구사항 분석(Requirements analysis)
관리자(Master)
* 관리자는 전체 사용자,일반사용자,팀장등에 대해 조회할 수 있다.
* 관리자는 권한을 설정할 수 있다.
* 관리자는 공지사항 게시글에 대한 작성, 수정, 삭제가 가능하다.

회원(User)
* 회원 가입을 할 수 있다.
* 회원 탈퇴를 할 수 있다.
* 로그인을 할 수 있다.
* 로그아웃을 할 수 있다.
* 소셜 로그인을 할 수 있다.
* 마이페이지를 통해 팀에 대한 정보 및 개인정보 확인,수정이 가능하다.
* 스터디 그룹을 만들 수 있다.
* 스터디에 참가 신청 할 수 있다.
* 스터디를 탈퇴 할 수 있다.
* 일반 사용자와, 관리자의 권한으로 나뉘어진다.
* 팀 모집 게시글에 대한 작성, 수정, 삭제가 가능하다.(일반사용자,관리자 가능)

게시판(Board)
* 팀 모집 게시판과 공지사항 2가지의 게시판이 존재한다.
* 게시글에 대해 작성,수정,삭제가가능하다. 
* 작성자에 작성한 회원의 이름이 표시된다.
* 글을 작성한 시간이 표시된다.
* 관리자와 회원은 댓글을 작성할 수 있다.
* 게시물을 삭제하면 달려있는 댓글들이 모두 삭제된다.
* 한명의 회원은 여러개의 게시판을 작성할 수 있다.
* 제목, 내용, 이미지를 올릴 수 있다.

공지사항(Notice)
* 관리자만 공지사항에 대한 수정과 삭제가 가능하다.
* 작성자에 관리자가 표시된다.
* 글을 작성한 시간이 표시된다.
* 제목, 내용, 이미지를 올릴 수 있다.
* 한명의 관리자는 여러개의 공지사항을 작성할 수 있다.

스터디 그룹(Group)
* 일정을 등록 ,관리 할 수 있다. 
* 회원을 초대할 수 있다.
* 회원 신청에 대해 처리할 수 있다.
* 그룹에 대한 설정을 다룰 수 있다.(그룹원 권한설정, 그룹 수정, 그룹 삭제 ...) 
* (보류) 공지사항 작성 

일정(Schedule)
* 제목, 내용 , 기간, 이미지 등에 대해 조회,등록,수정,삭제 할 수 있다.
* 참여하는 스터디원에 대해 조회,등록,수정,삭제 할 수 있다.
* 달성하였는지에 대해 체크한다.