import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*System.out.println("Hello World!");*/
		System.out.println("\n**************************************\n");
		System.out.println("\tWelcome to TheDesk \n");
		System.out.println("**************************************");
		optionsSelection();

	}
	private static void optionsSelection() {
		String[] arr = {"1. I wish to review my expenditure",
				"2. I wish to add my expenditure",
				"3. I wish to delete my expenditure",
				"4. I wish to sort the expenditures",
				"5. I wish to search for a particular expenditure",
				"6. Close the application"
		};
		int[] arr1 = {1,2,3,4,5,6};
		int  slen = arr1.length;
		for(int i=0; i<slen;i++){
			System.out.println(arr[i]);
			// display the all the Strings mentioned in the String array
		}
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		ArrayList<Integer> expenses = new ArrayList<Integer>();
		expenses.add(1000);
		expenses.add(2300);
		expenses.add(45000);
		expenses.add(32000);
		expenses.add(110);
		expenses.addAll(arrlist);
		System.out.println("\nEnter your choice:\t");
		Scanner sc = new Scanner(System.in);
		int  options =  sc.nextInt();
		for(int j=1;j<=slen;j++){
			if(options==j){
				switch (options){
				case 1:
					System.out.println("Your saved expenses are listed below: \n");
					System.out.println(expenses+"\n");
					optionsSelection();
					break;
				case 2:
					System.out.println("Enter the value to add your Expense: \n");
					int value = sc.nextInt();
					expenses.add(value);
					System.out.println("Your value is updated\n");
					expenses.addAll(arrlist);
					System.out.println(expenses+"\n");
					optionsSelection();

					break;
				case 3:
					System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
					int con_choice = sc.nextInt();
					if(con_choice==options){
						expenses.clear();
						System.out.println(expenses+"\n");
						System.out.println("All your expenses are erased!\n");
					} else {
						System.out.println("Oops... try again!");
					}
					optionsSelection();
					break;
				case 4:
					sortExpenses(expenses);
					optionsSelection();
					break;
				case 5:
					searchExpenses(expenses);
					optionsSelection();
					break;
				case 6:
					closeApp();
					break;
				default:
					System.out.println("You have made an invalid choice!");
					break;
				}
			}
		}

	}
	private static void closeApp() {
		System.out.println("Closing your application... \nThank you!");
	}
	private static void searchExpenses(ArrayList<Integer> arrayList) {
		int leng = arrayList.size();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the expense you need to search:\t");
		int searchExpenseValue=sc.nextInt();
		//Search a expense using Binary Search Technique 
		// BinarySearch needs sorted list, So sorting using merge sort
		mergeSort(arrayList,0,leng-1); 
		int left=0,right=leng-1;
		while(left<=right) {
			int mid=left+(right-left)/2;
			if(arrayList.get(mid)==searchExpenseValue) {
				System.out.println("Your expense "+searchExpenseValue+" is found");
				return;
			}
			else if(searchExpenseValue<arrayList.get(mid))right=mid-1;
			else left=mid+1;
		}
		System.out.println("Expense not found");

	}
	private static void sortExpenses(ArrayList<Integer> arrayList) {
		int arrlength =  arrayList.size();
		System.out.println("Your sorted expenses are listed below: \n");
		//Collections.sort(arrayList); //sort using inbuilt collections sort method.
		// sort the expenses list using merge-sort technique
		mergeSort(arrayList,0,arrlength-1);
		System.out.println(arrayList);

	}
	public static void mergeSort(ArrayList<Integer> arrayList,int l,int r) {
		if(l<r) {
			int mid=l+(r-l)/2;
			mergeSort(arrayList,l,mid);
			mergeSort(arrayList,mid+1,r);

			merge(arrayList,l,mid,r);
		}
	}
	public static void merge(ArrayList<Integer> arrayList, int l, int m, int r) {
		ArrayList<Integer>L=new ArrayList<>();
		ArrayList<Integer>R=new ArrayList<>();
		int Llength=m-l+1;
		int Rlength=r-m;
		for(int i=0;i<Llength;i++)L.add(arrayList.get(l+i));
		for(int i=0;i<Rlength;i++)R.add(arrayList.get(m+1+i));
		int i=0,j=0,k=l;
		while(i<Llength && j<Rlength) {
			if(L.get(i)<=R.get(j))arrayList.set(k++, L.get(i++));
			else arrayList.set(k++, R.get(j++));
		}
		while(i<Llength)arrayList.set(k++, L.get(i++));
		while(j<Rlength)arrayList.set(k++, R.get(j++));

	}
}
