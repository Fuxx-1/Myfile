use std::*;

fn main() {
    let x = [1, 2, 3];
    for ele in x.iter().enumerate() {
        println!("{}->{}", ele.0, ele.1);
    }
    for (index, value) in x.iter().enumerate() {
        println!("{}->{}", index, value);
    }
}