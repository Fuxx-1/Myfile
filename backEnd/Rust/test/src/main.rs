use std::io::stdin;
mod lib;
use crate::lib::mod_test::StructTest;

fn main() {
    let mut a: String = String::new();
    match stdin().read_line(&mut a) {
        Ok(n) => println!("{}", n),
        Err(error) => println!("error: {error}"),
    }
    a = a.trim().to_owned();
    let test = StructTest::new(a);
    println!("You input: \"{}\", The len is {}.", test.get_string(), test.get_len());
}

// fn get_len(str: &str) -> usize {
//     str.len()
// }
