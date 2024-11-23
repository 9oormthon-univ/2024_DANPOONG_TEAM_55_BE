## 👋🏻 SOMTORIONG 
<h5>나를 제일 잘 아는 멘토링 서비스, 솜토링 입니다.</h5>
![스크린샷 2024-11-24 오전 5.14.48.png](..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fct%2Fz8jjwffd1qd_cd23r35hkd700000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_YDmxrS%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-11-24%20%EC%98%A4%EC%A0%84%205.14.48.png)
## 🛠️ SYSTEM ARCHITECTURE DIAGRAM
![IMG_D65EA5A80BD9-1.jpeg](..%2F..%2FDownloads%2FIMG_D65EA5A80BD9-1.jpeg)

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
<div align=center>

| 이한음 |                                                                 신예준                                                                  |
|:---:|:------------------------------------------------------------------------------------------------------------------------------------:|
|  <a href="https://github.com/LeeHanEum"> <img src="https://avatars.githubusercontent.com/u/103233513?v=4" width=100px alt="_"/> </a> | <a href="https://github.com/y22jun"> <img src="https://avatars.githubusercontent.com/u/151177624?v=4" width=100px alt="_"/> </a> |
| **Server** |                                                              **Server**                                                              |

</div>