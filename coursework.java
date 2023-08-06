import java.util.*;
    class coursework{
		private static String[]UserDetail={"danujav","1234"};
		private static Scanner input=new Scanner(System.in);
		private static String[][]suppliers=new String[0][2];
		private static String[]item_category=new String[0];
		private static String[][]item=new String[0][6];
		private static double[]Price=new double [0];
		
		public static double[] grow_price(double[]Price){
			double[]temp=new double[Price.length+1];
			for(int i=0;i<Price.length;i++){
				temp[i]=Price[i];
			}
			return temp;
		}
		public static String[][] growItem(String[][]item){
			String[][]temp=new String[item.length+1][6];
			for(int i=0;i<item.length;i++){
				for(int j=0;j<item[i].length;j++){
					temp[i][j]=item[i][j];
				}
			}
			return temp;
		}
		public static String[] removeIc(int index){
			String[]temp=new String[item_category.length-1];
			for (int i=0,j=0;i<item_category.length;i++){
				if(i==index){
					continue;
				}else{
					temp[j++]=item_category[i];
				}
			}
			return temp;
		}
		public static String[] growIc(String[]item_category){
			String[]temp2=new String[item_category.length+1];
			for(int i=0;i<item_category.length;i++){
				
					temp2[i]=item_category[i];
				
			}
			return temp2;
		} 
		public static String[][] grow(String[][]suppliers){
			String[][]temp=new String[suppliers.length+1][2];
			for(int i=0;i<suppliers.length;i++){
				for(int j=0;j<suppliers[i].length;j++){
					temp[i][j]=suppliers[i][j];
				}
			}
			return temp;
		} 
		public static String[][] remove(int index){
			String[][]tempr=new String[suppliers.length-1][2];
			int x=0;
			L1:
			  for(int i=0;i<suppliers.length;i++){
				for (int j=0;j<suppliers[i].length;j++){
					if(i==index){
						continue L1;
					}else{
						tempr[x][j]=suppliers[i][j];
					}
				}
			     x++;
			}
			return tempr;
		}
		
		//item
		public static void backtohome(){
			System.out.print("Do you want to go to home page(Y/N)?");
			char ch1=input.next().charAt(0);
			if(ch1=='Y'||ch1=='y'){
				clearConsole();
				chooseOption();
			}else if(ch1=='N'||ch1=='n'){
				clearConsole();
				Supplier_Manage();
			}else{
				backtohome();
			}
		}
		public static void Rank_item_per_unit(){
			
			sortprice();
			System.out.printf("+-----------------+----------------+-----------------+-----------------+-----------------+-----------------+%n");
			System.out.printf("| %-15s | %-15s| %-15s | %-15s | %-15s | %-15s |%n","ItemCode","SuppId","category","Desc","Price","Qty");
			System.out.printf("+-----------------+----------------+-----------------+-----------------+-----------------+-----------------+%n");
			for(int i=0;i<Price.length;i++){
			   for(int j=0;j<Price.length;j++){
				  if(item[j][4].equals(String.valueOf(Price[i]))){
					System.out.printf("| %-15s | %-15s| %-15s | %-15s | %-15s | %-15s |%n",item[j][0],item[j][1],item[j][2],item[j][3],item[j][4],item[j][5]);
				  }
			   }
		    }
			System.out.printf("+-----------------+----------------+-----------------+-----------------+-----------------+-----------------+%n");
			backtohome();
		}
		public static void sortprice(){
			for(int i=0;i<Price.length-1;i++){
				for(int j=0;j<Price.length-1;j++){
					if(Price[j]>Price[j+1]){
						double temp=Price[j];
						Price[j]=Price[j+1];
						Price[j+1]=temp;
					}
				}
			}
		}
		public static void backinview(){
			System.out.print("Do you want to go to home page(Y/N)?");
			char ch1=input.next().charAt(0);
			if(ch1=='Y'||ch1=='y'){
				clearConsole();
				chooseOption();
			}else if(ch1=='N'||ch1=='n'){
				clearConsole();
				Supplier_Manage();
			}else{
				backinview();
			}
		}
		public static void View_items(){
			
			System.out.printf("+-----------------------------------------+%n");
			System.out.printf("|          VIEW ITEM                      |%n");
			System.out.printf("+-----------------------------------------+%n");
			
			String cat=null;
			for(int i=0;i<item_category.length;i++){
			       cat=item_category[i];
			       View_items2(cat);
			}
			backinview();
		}
		public static void View_items2(String cat){
		 
			System.out.println("\n"+cat+" : ");
			
			System.out.printf("+-----------------+------------------+-------------------+-----------------+-----------------+%n");
			System.out.printf("| %15s |  %15s |  %15s | %15s |  %15s |%n","ItemCode","SuppID","Desc","Price","Qty");
			System.out.printf("+-----------------+------------------+-------------------+-----------------+-----------------+%n");
			
			for(int i=0;i<item.length;i++){
				
			     if(cat.equals(item[i][2])){
                   System.out.printf("| %15s |  %15s | %15s |  %15s |  %15s |%n",item[i][0],item[i][1],item[i][3],item[i][4],item[i][5]);
			      }
			}
		    System.out.printf("+-----------------+------------------+-------------------+-----------------+-----------------+%n");
	    }
		public static void searchanother(){
			System.out.print("Do you want to search another supplier (Y/N)? ");
		    char ch1=input.next().charAt(0);
		    if(ch1=='Y'||ch1=='y'){
				clearConsole();
				Get_item_supp();
			}else if(ch1=='N'||ch1=='n'){
				clearConsole();
				Stock_Manage();
			}else{
				searchanother();
			}
		}
		public static void Get_item_supplier_vise(String sId){
			Scanner input=new Scanner(System.in);
			
			System.out.printf("+-----------------+------------------+-------------------+-----------------+-----------------+%n");
			System.out.printf("| %15s |  %15s |  %15s | %15s |  %15s |%n","ItemCode","Category","Desc","Price","Qty");
			System.out.printf("+-----------------+------------------+-------------------+-----------------+-----------------+%n");
	      
	         for(int i=0;i<item.length;i++){
				 if(item[i][1].equals(sId)){
		     System.out.printf("| %15s |  %15s | %15s |  %15s |  %15s |%n",item[i][0],item[i][2],item[i][3],item[i][4],item[i][5]);
				 }
			 }
			 System.out.printf("+-----------------+------------------+-------------------+-----------------+-----------------+%n");
			 
			 System.out.println("search successfully!!!");
			 searchanother();
	    }
		public static void Get_item_supp(){
			
			System.out.printf("+-----------------------------------------+%n");
			System.out.printf("|         SEARCH SUPPLIER                 |%n");
			System.out.printf("+-----------------------------------------+%n");
			
			System.out.print("Enter supplier Id : ");
			String sId=input.next();
			
			for(int i=0;i<suppliers.length;i++){
			    if(sId.equals(suppliers[i][0])){
					  System.out.println("Supplier Name :"+suppliers[i][1]);
					  Get_item_supplier_vise(sId);
				  }
		    }
			
		}
		
		
		public static void addAnotherItem(){
			System.out.print("Do you want to add another Item(Y/N)?");
			char ch1=input.next().charAt(0);
			if(ch1=='Y'||ch1=='y'){
				clearConsole();
				Add_item();
			}else if(ch1=='N'||ch1=='n'){
				clearConsole();
				Stock_Manage();
			}else{
				addAnotherItem();
			}
		}
		public static void categoryList(){
			System.out.println("Item Categories:");
			
			System.out.printf("+------+-----------------+%n");
			System.out.printf("| %-4s | %-15s |%n", "#", "CATEGORY NAME");
			System.out.printf("+------+-----------------+%n");
			for(int i=0;i<item_category.length;i++){
				System.out.printf("| %-4s | %-15s |%n",(i+1),item_category[i]);
			}
			System.out.printf("+------+-----------------+%n");
		}
		public static void supplierList(){
			System.out.println("Suppliers list: ");
			
			System.out.printf("+------+-----------------+----------------+%n");
			System.out.printf("| %-4s | %-15s | %-15s|%n","#","SUPPLIER ID","SUPPLIER NAME");
			System.out.printf("+------+-----------------+----------------+%n");
			
			for (int i=0;i<suppliers.length;i++){
				System.out.printf("| %-4s | %-15s | %-15s|%n",(i+1),suppliers[i][0],suppliers[i][1]);
			}
			System.out.printf("+------+-----------------+----------------+%n");
		}
		public static void additems(){
			Scanner input=new Scanner(System.in);
			boolean flag=false;
			L1:
			do{
			System.out.print("Item code   : ");
			String Item_code=input.next();
			    for(int i=0;i<item.length;i++){
					if(Item_code.equals(item[i][0])){
						System.out.print("Already exists, try again!!!" );
						flag=true;
						break;
					}
				}
				if(flag){
					flag=false;
					continue L1;
				}else{
					item=growItem(item);
					item[item.length-1][0]=Item_code;
					supplierList();
					
					System.out.print("Enter the supplier number > ");
		        	int number=input.nextInt();
					item[item.length-1][1]=suppliers[number-1][0];
					categoryList();
					
					System.out.print("Enter the category number > ");
					int c_number=input.nextInt();
					item[item.length-1][2]=item_category[c_number-1];
					
					System.out.print("\nDescription  : ");
					String description=input.next();
					item[item.length-1][3]=description;
					
					System.out.print("Unit price     : ");
					double price=input.nextDouble();
					item[item.length-1][4]=String.valueOf(price);
					Price=grow_price(Price);
					Price[Price.length-1]=price;
					
					
					System.out.print("Qty on hand    : ");
					int qty=input.nextInt();
					item[item.length-1][5]=String.valueOf(qty);
					
					System.out.print("\nadded successfully!  ");
					addAnotherItem();
				}
			}while(true);
		}
		public static void checkAddSupplier(){
		   Scanner input=new Scanner(System.in);
		   System.out.print("Do you want to add a new supplier?(Y/N)");
		   char ch1=input.next().charAt(0);
		   if(ch1=='Y'||ch1=='y'){
			   addNewsuppId();
		   }else if(ch1=='N'||ch1=='n'){
			   
		   }else{
			   checkAddSupplier();
		   }
		}
		public static void checkAddCat(){
			Scanner input=new Scanner(System.in);
		    System.out.print("Do you want to add a new category?(Y/N)");
		    char ch1=input.next().charAt(0);
		    if(ch1=='Y'||ch1=='y'){
			   Add_New_Item_category();
		    }else if(ch1=='N'||ch1=='n'){
			   
		    }else{
			   checkAddCat();
		    }
		}
		public static void check_supplier(){
			if(suppliers.length>0){
				additems();
			}else{
				System.out.print("OOPS! It seems that you don't have any suppliers in the system. ");
				checkAddSupplier();
			}
		}
		public static void check_item_cat(){
			if(item_category.length>0){
				check_supplier();
			}else{
				System.out.print("OOPS! It seems that you don't have any item catergories in the system. ");
				checkAddCat();
			}
	    }
		public static void Add_item(){
			
			System.out.printf("+-----------------------------------------+%n");
			System.out.printf("|          ADD ITEM                       |%n");
			System.out.printf("+-----------------------------------------+%n");
			
			check_item_cat();
		}
		public static void Update_another_category(){
			System.out.print("Do you want to update another category (Y/N)?");
			char ch1=input.next().charAt(0);
			if(ch1=='Y'||ch1=='y'){
				clearConsole();
				Update_Item_category();
			}else if(ch1=='N'||ch1=='n'){
				clearConsole();
				Manage_item_category();
			}else{
				Update_another_category();
			}
		}
		public static void Update_Item_category(){
			Scanner input=new Scanner(System.in);
			boolean flag=false;
			L1:
			do{
				System.out.print("category name : ");
				String catName=input.next();
				for(int i=0;i<item_category.length;i++){
					if(catName.equals(item_category[i])){
						System.out.print("Enter the new category name : ");
						String newCatName=input.next();
						item_category[i]=newCatName;
						System.out.print("Upadated sucessfully!!!");
						flag=true;
						Update_another_category();
					}
				}
				if(flag){
					flag=false;
					continue L1;
				}else{
				  System.out.print("Can't find category . try again!!!");
				  Update_Item_category();
				}
			}while(true);
		} 
		public static void delete_another_category(){
			System.out.print("Do you want to delete another catergory (Y/N) ? ");
			char ch1=input.next().charAt(0);
			if(ch1=='Y'||ch1=='y'){
				Delete_Item_category();
			}else if(ch1=='N'||ch1=='n'){
				clearConsole();
				Manage_item_category();
			}else{
				delete_another_category();
			}
		}
		public static void Delete_Item_category(){
			Scanner input=new Scanner(System.in);
			boolean flag=false;
			L1:
			do{
				System.out.print("Enter the category name : ");
				String catName=input.next();
				for(int i=0;i<item_category.length;i++){
					if(catName.equals(item_category[i])){
						int index=i;
						item_category=removeIc(index);
						System.out.print("Deleted successfully!!!");
						flag=true;
						delete_another_category();
					   }
				}
					if(flag){
						flag=false;
						continue L1;
					}else {
						System.out.print("can't find catergory. try again !!!");
						Delete_Item_category();
					}
			}while(true);
		}
		public static void add_another_Item(){
		    System.out.print("Do you want to add another category(Y/N)?");
			char ch1=input.next().charAt(0);
			if (ch1=='Y'||ch1=='y'){
				Add_New_Item_category();
			}else if(ch1=='N'||ch1=='n'){
				clearConsole();
				Manage_item_category();
			}else{
				add_another_Item();
			}
		}
		public static void Add_New_Item_category(){
			Scanner input=new Scanner(System.in);
			boolean flag=false;
			do{
			       System.out.print("Enter the new item category Name:");
			       String categoryName=input.next();
			
			   for(int i=0;i<item_category.length;i++){
				   if(categoryName.equals(item_category[i])){
				   System.out.print("Already exists, try another category name!!!");
				   flag=true;
				       break;
				   }
			   }if(flag){
				   flag=false;
				   continue ;
			   }else {
				   item_category=growIc(item_category);
				   item_category[item_category.length-1]=categoryName;
				   System.out.println("added successfully!");
				   add_another_Item();
			   }
		    }while(true);
		}
		public static void Manage_item_category(){
			Scanner input=new Scanner(System.in);
			
			System.out.printf("+-----------------------------------------+%n");
			System.out.printf("|         MANAGE ITEM CATEGORY            |%n");
			System.out.printf("+-----------------------------------------+%n");
			
			System.out.println("\n[1] Add New Item Category\t\t\t[2] Delete  Item Category");
			System.out.println("[3] Update Item Category\t\t\t[4] Stock Management");
			
			System.out.print("\n\nEnter an option to continue > ");
			int option=input.nextInt();
			clearConsole();
			switch(option){
				case 1:
				   Add_New_Item_category();
				   break;
			    case 2:
			       Delete_Item_category();
			       break;
			    case 3:
			       Update_Item_category();
			       break;
			    case 4:
			       Stock_Manage();
			       break;
			   }
		}
		public static void Stock_Manage(){
			
			System.out.printf("+-----------------------------------------+%n");
			System.out.printf("|          STOCK MANAGE                   |%n");
			System.out.printf("+-----------------------------------------+%n");
			
			System.out.println("\n[1] Manage item category\t\t[2] Add item");
			System.out.println("[3] Get item supplier vise\t\t[4] View items");
			System.out.println("[5] Rank item per unit\t\t\t[6]Home page");
			System.out.print("\n\nEnter an option to continue > ");
			int option=input.nextInt();
			clearConsole();
			switch(option){
				case 1:
				   Manage_item_category();
				   break;
			    case 2:
			       Add_item();
			       break;
			    case 3:
			       Get_item_supp();
			       break;
			    case 4:
			       View_items();
			       break;
			    case 5:
			       Rank_item_per_unit();
			    default:
			       chooseOption();
			}
		}
		
		//supplier
		public static void Search_supplierYN(){
		   System.out.print("\nDo you want to add another find(Y/N)? ");
		   char ch1=input.next().charAt(0);
			if(ch1=='Y'||ch1=='y'){
				Search_supplier();
			}else if(ch1=='N'||ch1=='n'){
				clearConsole();
				Supplier_Manage();
			}else{
				Search_supplierYN();
			}
		}
		public static void Search_supplier(){
			Scanner input=new Scanner(System.in);
			boolean flag=false;
		 L1:
			do{
			System.out.print("\nSupplier ID  : ");
			String Id=input.next();
			
			 for(int i=0;i<suppliers.length;i++){
				 if(Id.equals(suppliers[i][0])){
					 System.out.print("Supplier Name  : "+suppliers[i][1]);
					 System.out.print("\nadded successfully!!!");
					 flag=true;
					 Search_supplierYN();
				 }
			 }
			   if(flag){
					flag=false;
					continue L1;
			   }else{
				    System.out.print("can't find supplier.try again!!!"); 
				    Search_supplier();
			   }
		  }while(true);
	    }
		public static void View_supplierYN(){
			System.out.print("\nDo you want to go Supplier manage page(Y/N)? ");
		   char ch1=input.next().charAt(0);
			if(ch1=='Y'||ch1=='y'){
				clearConsole();
				Supplier_Manage();
			}else if(ch1=='N'||ch1=='n'){
				clearConsole();
				chooseOption();
			}else{
				View_supplierYN();
			}
		}
		public static void View_supplier(){
			
			System.out.printf("+-----------------------------------------+%n");
			System.out.printf("|         VIEW SUPPLIER                   |%n");
			System.out.printf("+-----------------------------------------+%n");
			
			 System.out.printf("+-----------------+-----------------+%n");
			System.out.printf("| %-15s | %-15s |%n", "SUPPLIER ID", "SUPPLIER NAME");
			 System.out.printf("+-----------------+-----------------+%n");
			
			for(int i=0;i<suppliers.length;i++){
				
				System.out.printf("| %-15s | %-15s |%n",suppliers[i][0],suppliers[i][1]);
			  
			}
		   System.out.printf("+-----------------+-----------------+%n");
		    
		   View_supplierYN();
		}
		public static void Delete_supplier(){
			System.out.print("Do you want to delete another ?(Y/N)");
			char ch1=input.next().charAt(0);
			if(ch1=='Y'||ch1=='y'){
				Delete_SupplierId();
			}else  if(ch1=='N'||ch1=='n'){
				clearConsole();
				Supplier_Manage();
			}else {
				Delete_supplier();
			}
		}
		public static void Delete_SupplierId(){
			Scanner input=new Scanner(System.in);
			boolean flag=false;
		L1:
		do{
			System.out.print("Supplier ID  : ");
			String Id=input.next();
			
		     for(int i=0;i<suppliers.length;i++){
			   if(Id.equals(suppliers[i][0])){
			     int index=i;
			     suppliers=remove(index);
			     System.out.print("deleted successfully!!! ");
			     flag=true;
			     Delete_supplier();
			   }
		     }
		     if(flag){
		        flag=false;
		        continue L1;
		     }else{
			  System.out.print("can't find supplier id.try again!!! ");
			   Delete_SupplierId();
		     }
		  }while(true);
	    } 
	    public static void Update_another_supplier(){
			Scanner input=new Scanner(System.in);
			System.out.print("Do you want to update another supplier?(Y/N)");
			char ch1=input.next().charAt(0);
			if(ch1=='Y'||ch1=='y'){
				Update_supplier();
			}else if(ch1=='N'||ch1=='n'){
				clearConsole();
				Supplier_Manage();
			}else{
				Update_another_supplier();
			}
		}
		public static void Update_supplier(){
			Scanner input=new Scanner(System.in);
			boolean flag=false;
			L1:
			do{
			   System.out.print("Supplier ID  :");
			   String Id=input.next();
			
			   for (int i=0;i<suppliers.length;i++){
				  if(Id.equals(suppliers[i][0])){
						System.out.print("Supplier  Name :"+suppliers[i][1]);
						System.out.print("\nEnter the new supplier name  :");
			            String Nname=input.next();
			            suppliers[i][1]=Nname;
			            System.out.print("updated Successfully!"); 
			            flag=true;
			            Update_another_supplier();
			      }  
			   }      
			   if(flag){
					flag=false;
					continue L1;
			   }else{
						System.out.print("can't find supplier.try again!!!"); 
						Update_supplier();
			   }
			}while(true);
	    }
		public static void addNewsuppId(){
	    Scanner input=new Scanner(System.in);
		boolean isexists = false; 
		
         L1:
         do {
             System.out.print("\nSupplier ID: ");
             String ids = input.next();
             for (int i = 0; i < suppliers.length; i++) {
                if (ids.equals(suppliers[i][0])) {
                   System.out.print("Already exists, try another ID!");
                   isexists = true; 
                      break;
                }
             }
             if(isexists) {
               isexists = false; 
                 continue L1; 
             }else{
                suppliers = grow(suppliers);
                suppliers[suppliers.length - 1][0] = ids;
                System.out.print("Supplier Name: ");
                String name = input.next();
                suppliers[suppliers.length - 1][1] = name;
                System.out.println("Supplier added successfully!");
                Add_Another_supplier();
             }
           }while(true);
           
	    }
		public static void Add_Another_supplier(){
			System.out.print("Do you  want to add another supplier(Y/N) ? ");
			char ch1=input.next().charAt(0);
			
			if(ch1=='Y'||ch1=='y'){
				addNewsuppId();
			}else if(ch1=='N'||ch1=='n'){
				clearConsole();
				Supplier_Manage();
			}else{
				Add_Another_supplier();
			}
		}
		public static void Add_supplier(){
			Scanner input=new Scanner(System.in);
			
			System.out.printf("+-----------------------------------------+%n");
			System.out.printf("|          ADD SUPPLIER                   |%n");
			System.out.printf("+-----------------------------------------+%n");
			
			addNewsuppId();
		}
		public static void Supplier_Manage() {
			System.out.printf("+-----------------------------------------+%n");
			System.out.printf("|          SUPPLIER MANAGE                |%n");
			System.out.printf("+-----------------------------------------+%n");
			
			System.out.println("\n[1] Add supplier\t\t\t[2] Update supplier");
			System.out.println("[3] Delete Supplier\t\t\t[4] View supplier");
			System.out.println("[5] Search supplier\t\t\t[6]Home page");
			System.out.print("\n\nEnter an option to continue > ");
			int option=input.nextInt();
			clearConsole();
			switch(option){
				case 1:
				  Add_supplier();
				   break;
			    case 2:
			       Update_supplier();
			       break;
			    case 3:
			       Delete_SupplierId();
			       break;
			    case 4:
			       View_supplier();
			       break;
			    case 5:
			       Search_supplier();
			    default:
			       chooseOption();
			}
		}
		public static void log_out(){
			login();
		}
		public static void checkYN(){
		    System.out.print(" Do you want to go home page(Y/N): ");
		        char ch1=input.next().charAt(0);
		        if(ch1=='Y'||ch1=='y'){
					clearConsole();
					chooseOption();
				}else if(ch1=='N'||ch1=='n'){
					clearConsole();
					Change_the_Credentials();
				}else{
					checkYN();
				}
		}
		public static void enterNewPassword(){
			Scanner input=new Scanner(System.in);
			System.out.print("\nEnter your new password : ");
			String password=input.next();
			UserDetail[1]=password;
			  if(UserDetail[1]==password){
			    System.out.print("Password changed sucessfullly!");
		      }
		      checkYN();
		}
		public static void inputPassword(){
			Scanner input=new Scanner(System.in);
			System.out.print("\nEnter your current password : ");
			String password=input.next();
			if(password.equals(UserDetail[1])){
				enterNewPassword();
			}else{
				System.out.print("incorrect password. try again!!! ");
				inputPassword();
			}
	    }
		public static void Change_the_Credentials(){
			Scanner input=new Scanner(System.in);
			
			System.out.print("\n\nplease enter the user name to verify it's you : ");
			String username=input.next();
			if(username.equals(UserDetail[0])){
				System.out.print("Hey "+UserDetail[0]);
				inputPassword();
			}else {
				System.out.print("invalid user name. try again!!!");
				    Change_the_Credentials();
			}
		}
		public static void chooseOption(){
			
			System.out.printf("+-----------------------------------------+%n");
			System.out.printf("| WELCOME TO IJSE STOCK MANAGEMENT SYSTEM |%n");
			System.out.printf("+-----------------------------------------+%n");
			
			System.out.println("\n[1] Change the Credentials\t\t[2] Supplier Manage");
			System.out.println("[3] Stock Manage\t\t\t[4] log out");
			System.out.println("[5] Exit the system");
			System.out.print("\n\nEnter an option to continue > ");
			int option=input.nextInt();
			clearConsole();
		
			switch(option){
				case 1:
				  Change_the_Credentials();
				   break;
			    case 2:
			       Supplier_Manage();
			       break;
			    case 3:
			       Stock_Manage();
			       break;
			    case 4:
			       log_out();
			       break;
			    default:
			       login();
			}
		}
		public static void clearConsole(){
			final String os = System.getProperty("os.name");
            try {
                   if (os.equals("Linux")) {
                   System.out.print("\033\143");
            } else if (os.equals("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                   System.out.print("\033[H\033[2J");
                   System.out.flush();
            }
            } catch (final Exception e) {
            //handle the exception
            System.err.println(e.getMessage());
            }
		}
		public static void userpassword(){
			System.out.print("Password  : ");
			String password=input.next();
			if(password.equals(UserDetail[1])){
				 clearConsole();
			     chooseOption();
			}else{
				System.out.println("password is  incorrect. please try again!!!");
				userpassword();
			}
		}
		public static void userName(){
			Scanner input=new Scanner(System.in);
			
			System.out.print("User Name  : ");
			String username=input.next();
			if(username.equals(UserDetail[0])){
			    userpassword();
			}else{
				System.out.println("user name is  invalid. please try again!!!");
				
				userName();
			   }
			}
		public static void login(){
			System.out.printf("+-----------------------------------------+%n");
			System.out.printf("|          LOGIN PAGE                     |%n");
			System.out.printf("+-----------------------------------------+%n");
			
			userName();
		}	
		public static void main(String args[]){
			login();
		}
	}
