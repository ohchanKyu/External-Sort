package externalSort;

import java.util.*;
import internalSort.QuickSort;

class Run
{
	int index;
	int data[];
	public Run(int index,int data[],int runSize,int number[],int runNumber) {
		this.index = index;
		if(index == runNumber) {
			this.data = new int[data.length - number[0]];
		}else {
			this.data = new int[runSize];
		}
		for(int i=0;i<runSize;i++) {
			if(number[0]+i >= data.length) {
				break;
			}
			this.data[i] = data[number[0]+i];
		}
		number[0]+=runSize;
	}
}

public class InternalSort {

	public static void main(String[] args) {
		
		int data[] = {
			109,49,34,68,45,2,60,38,28,47,16,19,34,55,
			98,78,76,40,35,86,10,27,61,92,99,72,11,2,29,16,
			80,73,18,12,89,50,46,36,67,93,22,14,83,44,52,59,10,
			38,76,16,24,85
		};
		QuickSort sort = new QuickSort();
		Scanner scanner = new Scanner(System.in);
		System.out.print("런의 크기를 입력해주세요 :");
		int runSize = scanner.nextInt();
		
		int runNumber;
		if(data.length % runSize == 0) {
			runNumber = data.length / runSize;
		}else {
			runNumber = data.length / runSize + 1;
		}
		int count[] = {0};
		Run run[] = new Run[runNumber];
		for(int i=0;i<run.length;i++) {
			run[i] = new Run(i+1,data,runSize,count,runNumber);
			sort.quickSort(run[i].data,0,run[i].data.length-1);
			System.out.print("Run["+run[i].index+"] : ");
			for(int j=0;j<run[i].data.length;j++) {
				System.out.print(run[i].data[j]+" ");
			}
			System.out.println();
		}
	}

}
