# lab8
I have included the Contact and AddressBook classes from the examples on the course site. Add the compareTo() method to the Contact class and specify that the class implements the Comparable interface. 2. Implement insertion sort in the AddressBook class. You will need to use the compareTo() method of the Contact class in the if statement.

His examples
-
compareTo Method

public int compareTo(Object obj) {
P
erson p = (Person) obj;

return name.compareTo(p.name);

}

insertionSort(a)
-
for i=1 to a.length-1 by 1 

current = a[i] 

for j=i-1 to 0 by -1 

if current < a[j] 

temp <- a[j+1] 

a[j+1] <- a[j] 

a[j] <- temp
