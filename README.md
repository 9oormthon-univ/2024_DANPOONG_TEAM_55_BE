## 👋🏻 SOMTORIONG 
<img width="592" alt="스크린샷 2024-11-24 오전 5 17 02" src="https://github.com/user-attachments/assets/ae4ceb6b-b412-4f32-9b8a-b22d13736dc8">

## 🛠️ SYSTEM ARCHITECTURE DIAGRAM
<img src="https://github.com/user-attachments/assets/adc549bb-af77-4549-b40d-0f8560601742" width="700">


## ⚙️ APPLICATION ARCHITECTURE DIAGRAM

```
somtoring-api
├── matching
│   ├── application
│   │    └── MatchingService
│   ├── domain
│   │    ├── MatchingRepository
│   │    └── Matching
│   ├── infrastructure
│   │    ├── MatchinQueryRepository
│   │    ├── MatchingJpaRepository
│   │    └── MatchingRepositoryImpl
│   └── presentation
│        └── MatchingController
```
- SOMTORING-API는 **도메인 주도 설계(DDD) 아키텍처를** 채택하여 비즈니스 로직과 인프라를 명확히 분리하고 유지보수성을 극대화합니다.
- 모든 도메인 패키지는 **application**, **domain**, **infrastructure**, **presentation의** 네 가지 주요 레이어로 구성되며, 일관된 구조를 유지합니다.

## 👨🏻‍💻 Developer

| 이한음 |                                                                 신예준                                                                  |
|:---:|:------------------------------------------------------------------------------------------------------------------------------------:|
|  <a href="https://github.com/LeeHanEum"> <img src="https://avatars.githubusercontent.com/u/103233513?v=4" width=100px alt="_"/> </a> | <a href="https://github.com/y22jun"> <img src="https://avatars.githubusercontent.com/u/151177624?v=4" width=100px alt="_"/> </a> |
| **Server** |                                                              **Server**                                                              |
