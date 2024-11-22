package goormthon.somtoring.domain.user.infrastructure.tag;

import org.springframework.data.jpa.repository.JpaRepository;

import goormthon.somtoring.domain.user.domain.tag.UserTag;

public interface UserTagJpaRepository extends JpaRepository<UserTag, Long>{
}
