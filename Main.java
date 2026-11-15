import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Main lab = new Main();

        try {
            while (true) {
                System.out.println("\nЛабораторная работа №1. Вариант 6");
                System.out.println("1 - Методы");
                System.out.println("2 - Условия");
                System.out.println("3 - Циклы");
                System.out.println("4 - Массивы");
                System.out.println("0 - Выход");

                int choice = lab.readInt("Номер задания: ");
                switch (choice) {
                    case 1:
                        lab.menu1();
                        break;
                    case 2:
                        lab.menu2();
                        break;
                    case 3:
                        lab.menu3();
                        break;
                    case 4:
                        lab.menu4();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("В меню нет такого задания.");
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("\nВвод закончился.");
        } finally {
            lab.input.close();
        }
    }

    private void menu1() {
        while (true) {
            System.out.println("\nЗадание 1. Методы:");
            System.out.println("3 - Букву в число");
            System.out.println("4 - Есть ли позитив");
            System.out.println("8 - Делитель");
            System.out.println("9 - Равенство");
            System.out.println("10 - Многократный вызов");
            System.out.println("0 - Назад");
            int choice = readInt("Номер задачи: ");

            switch (choice) {
                case 0:
                    return;
                case 3: {
                    System.out.print("Введите одну цифру: ");
                    String text = input.nextLine().trim(); // Читаем строку и удаляем пробелы в начале и конце
                    while (text.length() != 1 || !"0123456789".contains(text)) { // Проверяем, что введена ровно одна цифра
                        System.out.print("Ошибка. Введите одну цифру от 0 до 9: ");
                        text = input.nextLine().trim();
                    }
                    char x = text.charAt(0);
                    System.out.println("Результат: " + charToNum(x)); // Вывод результата
                    break;
                }
                case 4: {
                    int x = readInt("Введите целое число: ");
                    System.out.println("Результат: " + isPositive(x)); // Вывод результата
                    break;
                }
                case 8: {
                    int a = readInt("Введите первое число: ");
                    int b = readInt("Введите второе число: ");
                    System.out.println("Результат: " + isDivisor(a, b)); // Вывод результата
                    break;
                }
                case 9: {
                    int a = readInt("Введите первое число: ");
                    int b = readInt("Введите второе число: ");
                    int c = readInt("Введите третье число: ");
                    System.out.println("Результат: " + isEqual(a, b, c)); // Вывод результата
                    break;
                }
                case 10: {
                    int sum = readInt("Введите первое число: ");
                    sum = lastNumSum(sum, readInt("Введите второе число: "));
                    sum = lastNumSum(sum, readInt("Введите третье число: "));
                    sum = lastNumSum(sum, readInt("Введите четвёртое число: "));
                    sum = lastNumSum(sum, readInt("Введите пятое число: "));
                    System.out.println("Итого: " + sum); // Вывод результата
                    break;
                }
                default:
                    System.out.println("В меню нет такой задачи.");
            }
        }
    }

    private void menu2() {
        while (true) {
            System.out.println("\nЗадание 2. Условия: ");
            System.out.println("2 - Безопасное деление");
            System.out.println("5 - Тройной максимум");
            System.out.println("6 - Тройная сумма");
            System.out.println("7 - Двойная сумма");
            System.out.println("10 - Вывод дней недели");
            System.out.println("0 - Назад");
            int choice = readInt("Номер задачи: ");

            switch (choice) {
                case 0:
                    return;
                case 2: {
                    int x = readInt("Введите делимое: ");
                    int y = readInt("Введите делитель: ");
                    System.out.println("\nРезультат: " + safeDiv(x, y));
                    break;
                }
                case 5: {
                    int x = readInt("Введите первое число: ");
                    int y = readInt("Введите второе число: ");
                    int z = readInt("Введите третье число: ");
                    System.out.println("\nМаксимум: " + max3(x, y, z));
                    break;
                }
                case 6: {
                    int x = readInt("Введите первое число: ");
                    int y = readInt("Введите второе число: ");
                    int z = readInt("Введите третье число: ");
                    System.out.println("\nРезультат: " + sum3(x, y, z));
                    break;
                }
                case 7: {
                    int x = readInt("Введите первое число: ");
                    int y = readInt("Введите второе число: ");
                    System.out.println("\nРезультат: " + sum2(x, y));
                    break;
                }
                case 10: {
                    System.out.print("Введите день недели: ");
                    String day = input.nextLine();
                    printDays(day);
                    break;
                }
                default:
                    System.out.println("В меню нет такой задачи.");
            }
        }
    }

    private void menu3() {
        while (true) {
            System.out.println("\nЗадание 3. Циклы: ");
            System.out.println("1 - Числа подряд");
            System.out.println("4 - Степень числа");
            System.out.println("6 - Одинаковость");
            System.out.println("7 - Квадрат");
            System.out.println("9 - Правый треугольник");
            System.out.println("0 - Назад");
            int choice = readInt("Номер задачи: ");

            try {
                switch (choice) {
                    case 0:
                        return;
                    case 1: {
                        int x = readInt("Введите целое число: ");
                        System.out.println("Результат: " + listNums(x));
                        break;
                    }
                    case 4: {
                        int x = readInt("Введите основание: ");
                        int y = readInt("Введите неотрицательную степень: ");
                        while (y < 0) {
                            y = readInt("Степень должна быть от 0 и выше. Введите ещё раз: ");
                        }
                        System.out.println("Результат: " + pow(x, y));
                        break;
                    }
                    case 6: {
                        int x = readInt("Введите целое число: ");
                        System.out.println("Результат: " + equalNum(x));
                        break;
                    }
                    case 7: {
                        int x = readSize("Введите сторону квадрата: ");
                        square(x);
                        break;
                    }
                    case 9: {
                        int x = readSize("Введите высоту треугольника: ");
                        rightTriangle(x);
                        break;
                    }
                    default:
                        System.out.println("В меню нет такой задачи.");
                }
            } catch (ArithmeticException e) {
                System.out.println("Результат не помещается в тип int.");
            }
        }
    }

    private void menu4() {
        while (true) {
            System.out.println("\nЗадание 4. Массивы");
            System.out.println("1 — Поиск первого значения");
            System.out.println("2 — Поиск последнего значения");
            System.out.println("5 — Добавление массива в массив");
            System.out.println("8 — Объединение");
            System.out.println("10 — Удалить негатив");
            System.out.println("0 — Выход");
            int choice = readInt("Номер задачи: ");

            switch (choice) {
                case 0:
                    return;
                case 1: {
                    int[] arr = readArray("Введите массив.");
                    int x = readInt("Какое число найти? ");
                    System.out.println("Индекс: " + findFirst(arr, x));
                    break;
                }
                case 2: {
                    int[] arr = readArray("Введите массив.");
                    int x = readInt("Какое число найти? ");
                    System.out.println("Индекс: " + findLast(arr, x));
                    break;
                }
                case 5: {
                    int[] arr = readArray("Введите исходный массив.");
                    int[] ins = readArray("Введите массив для вставки.");
                    int pos = readInt("Позиция от 0 до " + arr.length + ": ");
                    while (pos < 0 || pos > arr.length) {
                        pos = readInt("Введите позицию от 0 до " + arr.length + ": ");
                    }
                    System.out.println(Arrays.toString(add(arr, ins, pos)));
                    break;
                }
                case 8: {
                    int[] arr1 = readArray("Введите первый массив.");
                    int[] arr2 = readArray("Введите второй массив.");
                    System.out.println(Arrays.toString(concat(arr1, arr2)));
                    break;
                }
                case 10: {
                    int[] arr = readArray("Введите массив.");
                    System.out.println(Arrays.toString(deleteNegative(arr)));
                    break;
                }
                default:
                    System.out.println("В меню нет такой задачи.");
            }
        }
    }

    // Задание 1
    // 3. Букву в число
    public int charToNum(char x) {
        return x - '0'; // '0' имеет код 48, '1' — 49 и так далее. Вычитая '0', мы получаем числовое значение цифры
    }

    // 4. Есть ли позитив
    public boolean isPositive(int x) {
        return x > 0; // Возвращает true, если x больше нуля, иначе false
    }

    // 8. Делитель
    public boolean isDivisor(int a, int b) {
        if (a != 0 && b % a == 0) { // Если a не равно нулю и b делится на a без остатка, то a является делителем b
            return true;
        }
        return b != 0 && a % b == 0; // Если b не равно нулю и a делится на b без остатка, то b является делителем a
    }

    // 9. Равенство
    public boolean isEqual(int a, int b, int c) {
        return a == b && b == c; // Возвращает true, если все три числа равны, иначе false
    }

    // 10. Многократный вызов
    public int lastNumSum(int a, int b) {
        int digitA = Math.abs(a % 10); // Получаем последнюю цифру числа a, используя модуль 10
        int digitB = Math.abs(b % 10); // Получаем последнюю цифру числа b, используя модуль 10
        return digitA + digitB; // Возвращаем сумму последних цифр двух чисел
    }

    // Задание 2
    // 2. Безопасное деление
    public double safeDiv(int x, int y) {
        if (y == 0) { // Проверяем делитель на ноль
            return 0; // Возвращаем 0, если делитель равен нулю
        }
        return (double) x / y; // Выполняем деление и возвращаем результат в виде double
    }

    // 5. Тройной максимум
    public int max3(int x, int y, int z) {
        int max = x; // Инициализируем max первым числом
        if (y > max) { // Сравниваем второе число с текущим максимумом
            max = y; // Обновляем максимум, если второе число больше
        }
        if (z > max) { // Сравниваем третье число с текущим максимумом
            max = z; // Обновляем максимум, если третье число больше
        }
        return max;
    }

    // 6. Тройная сумма
    public boolean sum3(int x, int y, int z) {
        return x + y == z || x + z == y || y + z == x; // Проверяем, равна ли сумма любых двух чисел третьему числу
    }

    // 7. Двойная сумма
    public int sum2(int x, int y) {
        int sum = x + y; // Вычисляем сумму двух чисел
        if (sum >= 10 && sum <= 19) { // Проверяем, находится ли сумма в диапазоне от 10 до 19 включительно
            return 20; // Если да, возвращаем 20
        }
        return sum;
    }

    // 10. Вывод дней недели
    public void printDays(String x) {
        switch (x.trim().toLowerCase()) {
            case "понедельник":
                System.out.println("понедельник");
            case "вторник":
                System.out.println("вторник");
            case "среда":
                System.out.println("среда");
            case "четверг":
                System.out.println("четверг");
            case "пятница":
                System.out.println("пятница");
            case "суббота":
                System.out.println("суббота");
            case "воскресенье":
                System.out.println("воскресенье");
                break;
            default:
                System.out.println("это не день недели");
        }
    }

    // Задание 3
    // 1. Числа подряд
    public String listNums(int x) {
        StringBuilder text = new StringBuilder(); // Собираем строку с числами
        for (long i = 0; i <= x; i++) { // Используем long, чтобы избежать переполнения при больших значениях x
            if (i > 0) { // Добавляем пробел перед числом, если это не первое число
                text.append(" ");
            }
            text.append(i);
        }
        return text.toString(); // Возвращаем строку с числами
    }

    // 4. Степень числа
    public int pow(int x, int y) {
        int result = 1; // Инициализируем результат как 1, так как любое число в степени 0 равно 1
        for (int i = 0; i < y; i++) { // Умножаем результат на x, y раз
            result = Math.multiplyExact(result, x); // Умножаем
        }
        return result;
    }

    // 6. Одинаковость
    public boolean equalNum(int x) {
        int digit = x % 10; // Получаем последнюю цифру числа
        x = x / 10; // Убираем последнюю цифру числа
        while (x != 0) { // Пока число не станет 0
            if (x % 10 != digit) { // Сравниваем последнюю цифру с предыдущей
                return false; // Если цифры не совпадают, возвращаем false
            }
            x = x / 10; // Убираем последнюю цифру числа
        }
        return true;
    }

    // 7. Квадрат
    public void square(int x) {
        for (int i = 0; i < x; i++) { // Проходим по каждой строке квадрата
            for (int j = 0; j < x; j++) { // Проходим по каждому столбцу квадрата
                System.out.print("*"); // Печатаем звёздочку
            }
            System.out.println(); // Переходим на новую строку после завершения строки квадрата
        }
    }

    // 9. Правый треугольник
    public void rightTriangle(int x) {
        for (int i = 0; i < x; i++) { // Проходим по каждой строке треугольника
            for (int j = 0; j < x - i - 1; j++) { // Печатаем пробелы перед звёздочками, чтобы сформировать правый треугольник
                System.out.print(" "); // Печатаем пробел
            }
            for (int j = 0; j <= i; j++) { // Печатаем звёздочки в каждой строке треугольника
                System.out.print("*"); // Печатаем звёздочку
            }
            System.out.println(); // Переходим на новую строку после завершения строки треугольника
        }
    }

    // Задание 4
    // 1. Поиск первого значения
    public int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) { // Проходим по массиву от начала до конца
            if (arr[i] == x) { // Если текущий элемент равен x
                return i; // Возвращаем индекс текущего элемента
            }
        }
        return -1;
    }

    // 2. Поиск последнего значения
    public int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--) { // Проходим по массиву от конца до начала
            if (arr[i] == x) { // Если текущий элемент равен x
                return i; // Возвращаем индекс текущего элемента
            }
        }
        return -1;
    }

    // 5. Добавление массива в массив
    public int[] add(int[] arr, int[] ins, int pos) {
        int[] result = new int[arr.length + ins.length]; // Создаём новый массив, который будет содержать элементы исходного массива и вставляемого массива
        for (int i = 0; i < pos; i++) { // Копируем элементы исходного массива до позиции вставки
            result[i] = arr[i];
        }
        for (int i = 0; i < ins.length; i++) { // Копируем элементы вставляемого массива в новый массив, начиная с позиции вставки
            result[pos + i] = ins[i]; 
        }
        for (int i = pos; i < arr.length; i++) { // Копируем оставшиеся элементы исходного массива после позиции вставки
            result[i + ins.length] = arr[i];
        }
        return result;
    }

    // 8. Объединение
    public int[] concat(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length]; // Создаём новый массив, который будет содержать элементы обоих массивов
        for (int i = 0; i < arr1.length; i++) { // Копируем элементы первого массива в новый массив
            result[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) { // Копируем элементы второго массива в новый массив
            result[arr1.length + i] = arr2[i];
        }
        return result;
    }

    // 10. Удалить негатив
    public int[] deleteNegative(int[] arr) {
        int count = 0; // Считаем количество неотрицательных элементов в массиве
        for (int i = 0; i < arr.length; i++) { // Проходим по массиву и считаем количество неотрицательных элементов
            if (arr[i] >= 0) { // Если элемент неотрицательный, увеличиваем счётчик
                count++;
            }
        }

        int[] result = new int[count]; // Создаём новый массив, который будет содержать только неотрицательные элементы
        int j = 0; // Индекс для нового массива
        for (int i = 0; i < arr.length; i++) { // Проходим по исходному массиву и копируем неотрицательные элементы в новый массив
            if (arr[i] >= 0) { // Если элемент неотрицательный, копируем его в новый массив
                result[j] = arr[i];
                j++;
            }
        }
        return result;
    }

// Вспомогательные методы для чтения данных
    // Метод для безопасного чтения целого числа
    private int readInt(String message) {
        while (true) {
            System.out.print(message);
            String text = input.nextLine().trim(); // Читаем строку и удаляем пробелы в начале и конце
            try {
                return Integer.parseInt(text); // Преобразуем строку в целое число и возвращаем его
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Введите целое число.");
            }
        }
    }

    // Метод для безопасного чтения размера массива
    private int readSize(String message) {
        int size = readInt(message); // Количество элементов в массиве
        while (size <= 0) { // Проверяем, что размер больше 0
            size = readInt("Размер должен быть больше 0. Введите ещё раз: ");
        }
        return size;
    }

    // Метод для безопасного чтения массива
    private int[] readArray(String message) {
        System.out.println(message);
        int size = readInt("Сколько элементов в массиве? ");
        while (size < 0) {
            size = readInt("Введите количество элементов от 0 и выше: ");
        }

        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = readInt("Элемент [" + i + "]: ");
        }
        return arr;
    }
}
