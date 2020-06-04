package phonebook;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBookAction {
    Scanner scanner = new Scanner(System.in);

    public void display(List<PhoneBook> phoneBookList) {
        for (PhoneBook phoneBook : phoneBookList) {
            System.out.println(phoneBook.toString());
        }
    }

    public void addPhoneBook(List<PhoneBook> phoneBookList) {
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
//        Pattern patternName = Pattern.compile("^[a-zA-Z].*");
//        Matcher matcherName = patternName.matcher(name);
//        while (!matcherName.matches()){
//            System.out.println("Bạn nhập sai dữ liệu, nhập lại tên");
//            name=scanner.nextLine();
//        }
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();

        System.out.println("Nhập số điện thoại:");
        String phoneNumber = scanner.nextLine();

        Pattern patternPhoneNumber=Pattern.compile("^[0][0-9]{9}");
        //ex 0978489648
        Matcher matcherPhoneNumble=patternPhoneNumber.matcher(phoneNumber);
        while (!matcherPhoneNumble.matches()){
            System.out.println("Bạn nhập sai dữ liệu, nhập lại Số điện thoại");
            name=scanner.nextLine();
        }

        System.out.println("Nhập Email: ");
        String email = scanner.nextLine();
        Pattern patternEmail = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
        Matcher matcherEmail = patternEmail.matcher(email);
        while (!matcherEmail.matches()){
            System.out.println("Bạn nhập sai dữ liệu, nhập lại email: ");
            email = scanner.nextLine();
        }

        System.out.println("Nhập facebook: ");
        String facebook = scanner.nextLine();
        int newPhone=Integer.parseInt(phoneNumber) ;
        phoneBookList.add(new PhoneBook(name, newPhone, address, email, facebook));
        System.out.println("Danh sách sau khi thêm mới:");
        display(phoneBookList);
    }

    public void updatePhonebook(List<PhoneBook> phoneBookList) {
        boolean check = false;
        int index = 0;
        System.out.println("Nhập số điện thoại cần cập nhật: ");
        int phoneNumber = scanner.nextInt();
        for (int i = 0; i < phoneBookList.size(); i++) {
            if (phoneBookList.get(i).getPhoneNumber() == phoneNumber) {
                check = true;
                index = i;
                break;
            } else {
                check = false;
            }
        }
        if (check) {
            scanner.nextLine();
            System.out.println("Nhập tên cần sửa: ");
            String name = scanner.nextLine();

            System.out.println("Nhập địa chỉ cần sửa: ");
            String address = scanner.nextLine();

            System.out.println("Nhập số điện thoại cần sửa:");
            String newPhoneNumber = scanner.nextLine();
            Pattern patternPhoneNumber=Pattern.compile("^[0][0-9]{9}");
            Matcher matcherPhoneNumble=patternPhoneNumber.matcher(newPhoneNumber);
            while (!matcherPhoneNumble.matches()){
                System.out.println("Bạn nhập sai dữ liệu, nhập lại Số điện thoại");
                newPhoneNumber=scanner.nextLine();
            }

            System.out.println("Nhập Email cần sửa: ");
            String email = scanner.nextLine();
            Pattern patternEmail = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
            Matcher matcherEmail = patternEmail.matcher(email);
            while (!matcherEmail.matches()){
                System.out.println("Bạn nhập sai dữ liệu, nhap lai email");
                email = scanner.nextLine();
            }

            System.out.println("Nhập facebook cần sửa: ");
            String facebook = scanner.nextLine();
            phoneBookList.get(index).setName(name);
            int newPhone=Integer.parseInt(newPhoneNumber) ;
            phoneBookList.get(index).setPhoneNumber(newPhone);
            phoneBookList.get(index).setAddress(address);
            phoneBookList.get(index).setEmail(email);
            phoneBookList.get(index).setFacebook(facebook);
            System.out.println("Danh sách sau khi sửa:");
            display(phoneBookList);
        } else {
            System.out.println("Số điện thoại bạn cần sửa không có trong danh bạ");

        }
    }

    public void deletePhonebook(List<PhoneBook> phoneBookList) {
        System.out.println("Nhập số điện thoại cần xóa trong danh bạ: ");
        boolean check = false;
        int index = 0;
        int inputValue = scanner.nextInt();
        for (int i = 0; i < phoneBookList.size(); i++) {
            if ((phoneBookList.get(i).getPhoneNumber() == inputValue)) {
                index = i;
                check = true;
                break;
            } else {
                check = false;
            }
        }
        if (check) {
            phoneBookList.remove(index);
            display(phoneBookList);
        } else {
            System.out.println("Số điện thoại bạn nhập ko tồn tại");
        }

    }

    public void searchPhoneBook(List<PhoneBook> phoneBookList) {
        System.out.println("Nhập số điện thoại cần tìm trong danh bạ: ");
        boolean check = false;
        int index = 0;
        int inputValue = scanner.nextInt();
        for (int i = 0; i < phoneBookList.size(); i++) {
            if ((phoneBookList.get(i).getPhoneNumber() == inputValue)) {
                index = i;
                check = true;
                break;
            } else {
                check = false;
            }
        }
        if (check) {
            System.out.println(phoneBookList.get(index).toString());
        } else {
            System.out.println("Số điện thoại bạn nhập ko tồn tại");
        }
    }
}
