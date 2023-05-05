#include<stdio.h>
#include<string.h>

int main()
{
	int cnt = 0;
	int t;
	char input[51];
	scanf("%d", &t);
	getchar();
	for (int i = 0; i < t; i++)
	{
		scanf("%s", input);

		for (int j = 0; j < strlen(input); j++)//strlen은 배열의 크기가 아니라 문자열의 크기이다 널문자는 제외해서 길이구함
		{
			if (input[j] == '(')
				cnt += 1;
			else if (input[j] == ')')
			{
				cnt -= 1;
				if (cnt < 0)
					break;
			}
		}
		if (cnt == 0)
			printf("YES\n");
		else
			printf("NO\n");
		cnt = 0;
	}
	return 0;
}