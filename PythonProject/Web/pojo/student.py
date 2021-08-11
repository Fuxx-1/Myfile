class student:
    Name = ""
    age = 0
    sex = 0

    def __init__(self, Name, age, sex):
        self.Name = Name
        self.Age = age
        self.Sex = sex

    def direct2json(self):
        return {
            'name': self.Name,
            'age': self.Age,
            'sex': self.Sex
        }