create table daangn.categories
(
  id         varchar(13)  not null comment '아이디'
        primary key,
  icon_url   varchar(255) not null comment '카테고리 아이콘 경로',
  name       varchar(100) not null comment '카테고리명',
  `order`    int          not null comment '정렬 순서',
  deleted    bit          not null comment '삭제 여부',
  created_at datetime     not null comment '생성 일자',
  updated_at datetime     not null comment '수정 일자'
)
  comment '카테고리 테이블';

create table daangn.categories_histories
(
  id            varchar(13)  not null,
  revision_id   bigint       not null,
  revision_type tinyint      not null,
  icon_url      varchar(255) not null,
  name          varchar(100) not null,
  `order`       int          not null,
  deleted       bit          not null,
  created_at    datetime     not null,
  updated_at    datetime     not null,
  primary key (id, revision_id)
)
  comment '카테고리 이력 테이블';

