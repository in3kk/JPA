package hello_jpa;

public class ValueMain {
    public static void main(String[] args) {
        //값 타입 비교 테스트
        int a = 10;
        int b = 10;
        System.out.println("a == b : "+(a==b));

        Address address1 = new Address("city","street","zipcode");
        Address address2 = new Address("city","street","zipcode");

        System.out.println("address1 == address2 : "+(address1 == address2));
        //equals도 기본이 동일성 비교(==)이기 때문에 override 해야함
        System.out.println("address1.equals(address2) : "+(address1.equals(address2)));


    }
}
