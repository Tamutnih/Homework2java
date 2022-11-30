
package aor.example;

public class task3 {

    public static void main(String[] args) {

        {
            StringBuilder returnString = new StringBuilder();
            returnString.Append("Фамилия: " + lastName + '\n');
            returnString.Append("Имя: " + firstName + '\n');
            String mark1;
            returnString.Append("Оценки\nПервая: " + mark1 + "\nВторая: " + mark2 + "\nТретья: " + mark3);

            return returnString.ToString();
        }

    }

    static int stringCount() {
        StreamReader fin = new StreamReader("data.txt", Encoding.Default);

        int i = 0;
        while (!fin.EndOfStream) {
            fin.ReadLine();
            i++;
        }
        return i;
    }

    static void readFromFile(ref Student[] st)
        { 
            StreamReader fin = new StreamReader("data.txt", Encoding.Default);
 
            int i = 0;
            while (!fin.EndOfStream)
            {
                char[] sep = { ';' };
                string st2 = fin.ReadLine(); // чтение строки из файла
                if (st2.Length > 1) // Если строка не пуста
                {
                    string[] pole = st2.Split(sep);// разделяем ее на поля, отделенные ";"
 
                    // присвоение элементов массива pole полям массива структур
                    st[i].lastName = pole[0];
                    st[i].firstName = pole[1];
 
                    // с преобразованием некоторых строк и числа
                    st[i].mark1 = int.Parse(pole[2]);
                    st[i].mark2 = int.Parse(pole[3]);
                    st[i].mark3 = int.Parse(pole[4]);
 
                    i++;
                }
            }
        }

    static void sort(ref Student[] st)
        {
            for (int i = 0; i < st.Length; i++)
            {
                for (int j = 0; j < st.Length - i - 1; j++)
                {
                    if (st[j].mark1 < st[j + 1].mark1)
                    {
                        Student temp = st[j];
                        st[j] = st[j + 1];
                        st[j + 1] = temp;
                    }
                }
            }
        }

    static void Main(string[] args)
        {
            Student[] st = new Student[stringCount()];

    readFromFile(ref st);

    sort(ref st);for(

    int i = 0;i<st.Length;i++)Console.WriteLine(st[i].ToString()+"\n==================");
}}
