pub mod mod_test {
    ///
    /// #Test
    pub struct StructTest {
        string: String,
        len: usize,
    }

    impl StructTest {
        pub fn new(str: String) -> StructTest {
            let len = str.len();
            StructTest {
                string: str,
                len,
            }
        }

        pub fn get_string(&self) -> String {
            self.string.clone()
        }

        pub fn get_len(&self) -> usize {
            self.len
        }
    }
}
