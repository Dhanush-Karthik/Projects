DESCRIPTION OF THE PROJECT:
This project is developed to make the parking easier in metropolitan cities with the help of computer application. This project is developed using linked list. In this project it will get details from the user to park the car in the empty slot and generates a receipt with token number. In order to take your car from the parking area you have to just enter your token number, it will de-allocate your booked slot.

MODULES:
DOUBLY LINKED LIST:
It is convenient to traverse lists backwards. Add an extra field to the data structure, containing a pointer to the previous cell.

        The cost of this is an extra link, adds to the space requirement and also doubles the cost of insertions and deletions because there are more pointers to fix.

        A doubly linked list is a concrete data structure consisting of a sequence of nodes
            1) Each node stores
            2) Data (Element)
        Pointers (Prev and Next) - Link to the previous and next node

        The Pointers store the address of the previous and next node.

STRUCTURE:

    Structure is a user-defined data type in C language which allows us to combine data of different types together. Structure helps to construct a complex data type which is more meaningful. It is somewhat similar to an Array, but an array holds data of similar type only. In structure, data is stored in form of records. In our project we have used structure to store data from the user and to create doubly linked list.
        struct parking{
            char name[15],brand[12],type[10],no_plate[15];
            int no;
        }pk[50];
