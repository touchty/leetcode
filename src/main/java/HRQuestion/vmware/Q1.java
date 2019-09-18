package HRQuestion.vmware;

/*
void calPalin(int iNum)
{
	int iHalfLen,iHalf,iDegree,iDigit,iResult; //iHalfLen是回文数对称左边有几位，如12521左边是3位数
	//iHalf是回文数对称的左边一半，如12521中的125；iDegree表示几位数；
	//iDigit表示某一几位数有多少回文数，如3位数有90个； iResult是结果
	int i;

	iDigit=9;   //赋初值为9

	for (iDegree=1;;iDegree++)
	{
		if (iNum-iDigit<=0)  //该处=0时一定要退出！！
		{
			break;
		}

		iNum-=iDigit;
		if (iDegree%2==0)  //一位数和二位数中的回文数是一样多，三位数和四位数中也一样。。。
		{
			iDigit*=10;
		}
	}

	iHalfLen=(iDegree+1)/2;   //算某一回文数左边的位数，如12521左边有3位

	iHalf=1;        //我觉得精华之所在
	for (i=2;i<=iHalfLen;i++)
	{
		iHalf*=10;
	}
	iHalf+=iNum-1;

	iResult=iHalf;
	if (iDegree&1)  //如果是奇位数，那么右边比左边一半少一位
	{
		iHalf/=10;
	}

	while (iHalf)   //求最终结果
	{
		iResult=iResult*10+iHalf%10;
		iHalf/=10;
	}

	printf("The result is :   %d\n\n",iResult);
}
 */
public class Q1 {
    public static long kP(int n, int iNum) {
        if (n == 1)
            return iNum - 1;
        int halfLen;
        int half;
        int result;

        half = 1;
        halfLen = (n + 1) / 2;


        for (int i = 2; i <= halfLen; i++) {
            half *= 10;
        }
        half += iNum - 1;

        result = half;
        if ((n & 1) != 0) { // 奇数
            half /= 10;
        }

        while (half != 0) {
            result = result * 10 + half % 10;
            half /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        int n1 = 1;
        int i1 = 5;
        System.out.println(kP(n1, i1));
        /*int n2 = 4;
        int i2 = 20;
        System.out.println(kP(n2, i2));*/
    }
}
