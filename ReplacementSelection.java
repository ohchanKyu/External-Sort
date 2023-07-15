package externalSort;

import java.util.*;

class ReplacementRun
{
	int index;
	Vector<Integer> vector = new Vector<>();
	public ReplacementRun(int index) {
		this.index = index;
	}
	public void addData(int data) {
		vector.add(data);
	}
	public void printData() {
		System.out.print("Run["+this.index+"] : ");
		for(int i=0;i<vector.size();i++) {
			System.out.print(vector.get(i)+" ");
		}
		System.out.println();
	}
	
}

public class ReplacementSelection {

	public static void main(String[] args) {
		
		int data[] = {
				109,49,34,68,45,2,60,38,28,47,16,19,34,55,
				98,78,76,40,35,86,10,27,61,92,99,72,11,2,29,16,
				80,73,18,12,89,50,46,36,67,93,22,14,83,44,52,59,10,
				38,76,16,24,85
		};
		Scanner scanner = new Scanner(System.in);
		System.out.print("초기 레코드 판독의 개수를 입력해 주세요 :");
		int number = scanner.nextInt();
		
		int record[] = new int[number];
		boolean frozen[] = new boolean[number];
		int frozenCount = 0;

		int insertCount = 0;
		int runIndex = 0;
		int dataIndex = number;
		
		for(int i=0;i<record.length;i++) {
			record[i] = data[i];
			frozen[i] = false;
		}
		
		LinkedList<ReplacementRun> run = new LinkedList<>();
		while(insertCount <= data.length) {
			
			for(int i=0;i<frozen.length;i++) {
				frozen[i] = false;
			}
			
			frozenCount = 0;
			runIndex++;
			int num = runIndex-1;
			run.add(new ReplacementRun(runIndex));
			int min = -1;
			if(record[0] != -1) {
				min = record[0];
			}
			int recordIndex = 0;
			for(int i=0;i<record.length;i++) {
					if(min == -1) {
						min = record[i];
						recordIndex = i;
					}else if(min != -1 && min > record[i]) {
						min = record[i];
						recordIndex = i;
					}
			}
			if(min != -1) {
				run.get(num).addData(min);
			}
			insertCount++;
			if(dataIndex < data.length) {
				record[recordIndex] = data[dataIndex];
				if(min > data[dataIndex]) {
					frozen[recordIndex] = true;
					frozenCount++;
				}
				dataIndex++;
			}else if(dataIndex >= data.length) {
				frozen[recordIndex] = true;
				frozenCount++;
			}
			while(frozenCount<frozen.length) {
				int minData = -1;
				recordIndex = 0;
				for(int i=0;i<record.length;i++) {
					if(frozen[i]==false) {
						if(minData == -1) {
							minData = record[i];
							recordIndex = i;
						}else if(minData != -1 && minData > record[i]) {
							minData = record[i];
							recordIndex = i;
						}
					}
				}
				if(minData != -1) {
					run.get(num).addData(minData);
				}
				insertCount++;
				if(dataIndex >= data.length) {
					record[recordIndex] = -1;
					frozen[recordIndex] = true;
					frozenCount++;
				}else {
					record[recordIndex] = data[dataIndex];
					if(minData > data[dataIndex]) {
						frozen[recordIndex] = true;
						frozenCount++;
					}
				}
				dataIndex++;
			}
		}
		ReplacementRun Run[] = new ReplacementRun[run.size()];
		for(int i=0;i<Run.length;i++) {
			Run[i] = run.get(i);
			Run[i].printData();
		}
	}

}
