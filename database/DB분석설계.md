# DB 분석 설계
## 데이터 모델링
> &nbsp;사용자의 요구 사항을 듣고 사용자의 관점을 분석해 이를 추상화하여 문서화하는 과정이며, DB 설계과정에서 데이터의 구조를 이해하기 위해 사용하는 도구.  
` 데이터베이스 설계란 개념적인 구조와 논리적인 구조를 거쳐 실제 데이터를 저장할 수 있는 물리적인 구조로 변환하기 위한 과정`
>
![image](https://github.com/JeHa-An/KOSTA/assets/106300022/ede6ba69-af9a-4e79-b84f-e04d2bc2c49e)

## 요구사항 분석
> &nbsp;데이터 모델링을 위해 사용자와의 면담을 통해 얻는 내용으로 요구사항을 간단하게 기술해 산출물인 요구 사항 명세서를 만든다.  

## 개체 관계 모델(논리적 설계 단계)
> 이 단계는 산출물(요구 사항 명세서)을 근거로 데이터 모델링 업무 처리에 필요한 자료와 속성을 기술하고, 자료 간의 관계를 정의하고 DB에 구애되지 않고 골격을 구축하는 작업 단계 이 단계에서 가장 일반적으로 사용되는 모델링 기법으로 **개체 관계 모델(Entity Relationship Diragram) EDR** 이 있다.

![image](https://github.com/JeHa-An/KOSTA/assets/106300022/b37bf833-7baa-4868-8e16-437bab451c17)


- 릴레이션 = Table, 도메인 = column, 튜플 = row, 속성 = column_name
![image](https://github.com/JeHa-An/KOSTA/assets/106300022/d9f0b3c5-219d-48f3-aaca-862882d149c6)

## 물리적 설계
> 이 단계의 목적은 개발에 사용할 DB를 선정하여 특정 DB로 구현될 수 있도록 구체적으로 설계하는 과정
- 일대일 관계(1:1)  
![image](https://github.com/JeHa-An/KOSTA/assets/106300022/b7e41b99-ac01-4950-9b4d-7dadef958490)

- 일대다 관계(1:n)  
![image](https://github.com/JeHa-An/KOSTA/assets/106300022/408e55ac-e564-4071-a63c-e6e61fd56d90)

- 다대다 관계(n:m)  
![image](https://github.com/JeHa-An/KOSTA/assets/106300022/a00ec4e3-a7f6-4eeb-8c01-18939873e21a)
