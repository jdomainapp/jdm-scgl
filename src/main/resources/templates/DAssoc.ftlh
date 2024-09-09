@DAssoc(
    ascName = "${ascName}",
    role = "${role}",
    ascType = ${ascType},
    endType = ${endType},
    associate = @Associate(
        type = Student.class,
        cardMin = 1,
        cardMax = 1,
        determinant = true
    )
)