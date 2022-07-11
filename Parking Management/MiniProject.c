#include <stdio.h>
#include<stdlib.h>
#include<string.h>
int count=0,row=0,column=0,user = 0,to;
int token[5][10];
struct parking{
    char name[15],brand[12],type[10],no_plate[15];
    int no;
}pk[50];
struct Node{
    int data;
    struct Node* next;
    struct Node* down;
}*head = NULL,*newNode,*temp,*prevNode;
void newnode( int data){
    if(count >=10){
    row++;
    }
    newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    newNode->down = NULL;
    if(head == NULL){
        head = temp = prevNode = newNode ;
    }else{
        temp->next = newNode;
        temp = temp->next;
        if(row >= 1){
            temp->down = prevNode;
            prevNode = prevNode->next;
        }
    }
    count++;
}
void park(struct parking pk[]){
    temp = head;
    row = column = count = 0;
    while(temp!=NULL){
        if(count%10 == 0 && count != 0){
            column = 0;
            row++;
        }
        if(temp->data == 0){
            int cho;
            printf("\n\nTHERE IS AN EMPTY SLOT IN ROW: %d COLUMN: %d.\nDO YOU WANT TO PARK?(YES(1)/NO(0)):",row+1,column+1);
            scanf("%d",&cho);
            if(cho == 1){
                system("clear");
                printf("YOUR VEHICLE HAS BEEN PARKED IN ROW: %d COLUMN: %d.\n",row+1,column+1);
                pk[user].no = token[row][column];
                user++;
                temp->data = 1;
                break;
            }
            else{

            }
        }
        column++;
        count++;
        temp = temp->next;
    }
}
void takeaway(){
    temp = head;
    for(int i = 0;i<5;i++){
        for(int j = 0;j<10;j++){
            if(token[i][j]==to){
                temp->data = 0;
                printf("\nYOUR CAR IS IN ROW: %d COLUMN: %d.",row+1,column+1);
                break;
            }
            temp=temp->next;
        }
    }
}
void display(){
    printf("PARKING VIEW : \n\n|0| - REPRESENTS EMPTY SLOT \n|1| - REPRESENTS OCCUPIED\n");
    temp = head;
    int n =0;
    printf("\n-----------------------------------------------------------------------------\n");
    while(temp!=NULL){
        if(n%10 == 0 && n!=0){
            printf("|end|");
            printf(" \n | | | | | | | | | |\n");
            printf(" V V V V V V V V V V\n");
        }
        printf("|%d| -> ",temp->data);
        temp = temp->next;
        n++;
    }
    printf("|end|");
    printf("\n-----------------------------------------------------------------------------\n");
}
void getdata(struct parking pk[]){
    printf("Enter the details: \n");
    printf("NAME: ");
    scanf("%s",pk[user].name);
    printf("BRAND: ");
    scanf("%s",pk[user].brand);
    printf("TYPE(CAR 🚙 / BIKE 🚙 ): ");
    scanf("%s",pk[user].type);
    printf("NUMBER PLATE: ");
    scanf("%s",pk[user].no_plate);
}
void displaydetails(struct parking pk[],int to){
    for(int i = 0;i<50;i++){
        if(to == pk[i].no){
            printf("\nDetails of the car: \n");
            printf("NAME: %s",pk[i].name);
            printf("\nBRAND: %s",pk[i].brand);
            printf("\nTYPE: %s",pk[i].type);
            printf("\nNUMBER PLATE: %s\n",pk[i].no_plate);
        }
    }
}
void receipt(struct parking pk[]){
    int a=user-1;
    printf("---------------------------------\n");
    printf(" RECEIPT OF PARKING ");
    printf("\nDetails of the car: \n");
    printf("NAME: %s",pk[a].name);
    printf("\nBRAND: %s",pk[a].brand);
    printf("\nTYPE: %s",pk[a].type);
    printf("\nNUMBER PLATE: %s\n",pk[a].no_plate);
    printf ("\nTOKEN NUMBER : %d",token[row][column]);
    if(strcmp(pk[a].type,"CAR")==0 || strcmp(pk[a].type,"car")==0 || strcmp(pk[a].type,"Car")==0){
        printf("\nPARKING CHARGE : RS.50");
    }else if(strcmp(pk[a].type,"BIKE")==0 || strcmp(pk[a].type,"bike")==0 || strcmp(pk[a].type,"Bike")==0){
        printf("\nPARKING CHARGE : RS.25");
    }else{
        printf("\nPARKING CHARGE : RS.100");
    }
    printf("\n---------------------------------\n");
}
int main()
{
    int ch=1,temp,t=2;
    for(int i = 0;i<50;i++){
        if(i==0)
            newnode(1);
        else if(i%3 == 0 || i%4 == 0 && i%2 == 0)
            newnode(0);
        else
            newnode(1);
    }
    for(int i = 0; i<5;i++){
        for(int j=0;j<10;j++){
            token[i][j]=951+((i*10)+j);
        }
    }
    printf("----WELCOME TO PARKING AREA----\n");
    while(ch!=0){
        printf("DO YOU WANT TO PARK OR DRIVE AWAY?\nPARK(1)\nDRIVE AWAY(2)\n");
        scanf("%d",&ch);
        system("clear");
        if(ch==1){
            char d;
            getdata(pk);
            system("clear");
            display();
            park(pk);
            display();
            printf("Enter any value to generate your recipt: ");
            scanf("%s",&d);
            system("clear");
            receipt(pk);
            printf("Enter 1 to exit.");
            scanf("%d",&temp);
            system("clear");
            ch = 1;
        }if(ch == 2){
            t=2;
            while(t==2){
                system("clear");
                printf("ENTER YOUR TOKEN NUMBER: ");
                scanf("%d",&to);
                displaydetails(pk,to);
                printf("IS THIS YOUR DETAILS?(YES(1)/NO(0)): ");
                scanf("%d",&t);
                system("clear");
                if(t==1){
                    takeaway();
                    display();
                    printf("\nTHANKS FOR CHOOSING OUR PARKING \n VISIT AGAIN ");
                    printf("\nEnter 1 to exit.");
                    scanf("%d",&temp);
                    system("clear");
                }else{
                    t=2;
                }
            }
        }
    }
    return 0;
}