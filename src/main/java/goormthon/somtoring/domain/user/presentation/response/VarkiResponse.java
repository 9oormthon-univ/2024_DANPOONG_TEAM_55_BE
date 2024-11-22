package goormthon.somtoring.domain.user.presentation.response;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import goormthon.somtoring.domain.user.domain.user.Varki;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record VarkiResponse(
	@Schema(description = "v", example = "10", requiredMode = REQUIRED)
	int v,

	@Schema(description = "a", example = "20", requiredMode = REQUIRED)
	int a,

	@Schema(description = "r", example = "30", requiredMode = REQUIRED)
	int r,

	@Schema(description = "k", example = "10", requiredMode = REQUIRED)
	int k,

	@Schema(description = "i", example = "20", requiredMode = REQUIRED)
	int i
) {
	public static VarkiResponse from(Varki varki) {
		return VarkiResponse.builder()
			.v(varki.getV())
			.a(varki.getA())
			.r(varki.getR())
			.k(varki.getK())
			.i(varki.getI())
			.build();
	}
}
