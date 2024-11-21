package goormthon.somtoring.domain.userQuestion.infrastructure;

import static goormthon.somtoring.domain.userQuestion.domain.QUserQuestion.userQuestion;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserQuestionQueryRepository {
	private final JPAQueryFactory queryFactory;

	public List<Long> findAnsweredQuestionIds(Long userId) {
		return queryFactory.select(userQuestion.question.id)
			.from(userQuestion)
			.where(userQuestion.user.id.eq(userId))
		.fetch();
	}

}
