library(datasets)
hist(iris$Sepal.Length[1:5])
gra<-density(iris$Sepal.Length[1:5])
plot(gra)
pie(table(iris$Species))




