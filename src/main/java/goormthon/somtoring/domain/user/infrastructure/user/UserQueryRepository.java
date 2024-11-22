package goormthon.somtoring.domain.user.infrastructure.user;

import static goormthon.somtoring.domain.user.domain.user.QUser.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import goormthon.somtoring.domain.user.domain.user.Role;
import goormthon.somtoring.domain.user.domain.user.User;
import goormthon.somtoring.domain.user.domain.user.Varki;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserQueryRepository {
	private final JPAQueryFactory queryFactory;

	public List<User> findAllByRoleAndVarki(Role role, Varki myVarki) {
		return queryFactory.selectFrom(user)
			.where(user.role.eq(role))
			.orderBy(
				Expressions.numberTemplate(Double.class,
					"POWER({0} - {1}, 2) + POWER({2} - {3}, 2) + POWER({4} - {5}, 2) + POWER({6} - {7}, 2) + POWER({8} - {9}, 2)",
					user.varki.v, myVarki.getV(),
					user.varki.a, myVarki.getA(),
					user.varki.r, myVarki.getR(),
					user.varki.k, myVarki.getK(),
					user.varki.i, myVarki.getI()
				).asc()
			)
			.limit(5)
			.fetch();
	}

}
