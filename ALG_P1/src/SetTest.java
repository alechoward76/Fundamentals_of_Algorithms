public class SetTest
{ // Simple main function to test ADT Set
    public static void main(String[] args)
    {
      Integer[] M ={2,3,5,7,11,13,17,19,23,29};
      Integer[] N = {1,3,6,8,9,11,12,17,19,23,24,25,3};
	
      SetClass<Integer> A = new SetClass<Integer>(); 
      A.insert(10);
      A.arrayInsert(M);
      System.out.println("\nSet A Follows:");
      A.print();

      SetClass<Integer> B = new SetClass<Integer>(); 
      B.arrayInsert(N);
      B.insert(11);
      System.out.println("\nSet B Follows:");
      B.print();

      SetClass<Integer> C = A.union(B);
      SetClass<Integer> D = A.intersection(B);
      System.out.println("\nSet C which is (A Union B) Follows:");
      C.print();
      System.out.println("\nSet D which is (A intersect B) Follows:");
      D.print();

      SetClass<Integer> E = A.difference(B);
      SetClass<Integer> F = B.difference(A);
      System.out.println("\nSet E which is (A - B) Follows:");
      E.print();
      System.out.println("\nSet F which is (B - A) Follows:");
      F.print();
      System.out.println("\nElement 2 in Set E:");
      System.out.println(E.in(2));
      System.out.println("\nElement 2 in set F:");
      System.out.println(F.in(2)); 
   } // end main
} 