package com.study.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/*
@NoArgsConstructor
@AllArgsConstructor
*/

/*
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
*/

// 위의 어노테이션을 하나로 만든 어노테이션
/*
 * 생성자 1개만 생성됨
	- @NonNull이 붙어있는 필드만 매개변수로한 생성자
	- @NonNull이 하나도 없을때는 매개변수가 없는 생성자	  
*/

@NoArgsConstructor
@Data
public class Board {
	@NonNull // null값을 가질 수 없다 null이면 exception발생
	private int no;
	private String title;
	private String writer;
	private String content;
}