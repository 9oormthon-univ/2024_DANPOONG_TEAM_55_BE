package goormthon.somtoring.common.util;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class RandomNicknameGenerator {

	private final List<String> adjectives = List.of(
		"산뜻한", "귀여운", "맑은", "싱그러운", "즐거운", "따뜻한", "행복한", "차분한", "편안한", "부드러운"
	);

	private final List<String> nouns = List.of(
		"구름", "안개", "뭉게구름", "바람", "무지개", "하늘", "태양", "달", "별", "햇살"
	);

	private final Random random = new Random();

	public String generate() {
		String adjective = adjectives.get(random.nextInt(adjectives.size()));
		String noun = nouns.get(random.nextInt(nouns.size()));
		return adjective + " " + noun;
	}
}
