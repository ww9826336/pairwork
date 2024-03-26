*合作搭档:黄浩，学号：
*代码存在的不足：
1. 做出多种尝试但还是未能保证随机生成题目时的计算过程中出现除法的被除数是0，且仍有可能计算过程产生负数；
2. 未能保证题目完全不重复的情况，虽然重复概率极低
   
*代码覆盖率*：
<img width="391" alt="屏幕截图 2024-03-26 102848" src="https://github.com/ww9826336/pairwork/assets/128201562/166d5ab2-7dbf-46a3-a7af-8ab95e7f29a4">

*性能分析*：
1. 由于未能及时导入Jprofile插件，暂时不能由软件实现自动分析；
2. 个人意见程序主要耗时在ExpressionParsing()即表达式解析函数以及GenerateExpression()即生成表达式模块上，
且其中表达式解析函数由于开拓栈内存占用内存较多，另外GenerateQuestions()即生成相应要求的题目数量上占用内存也较多

*总结*：
*优点：
1. 二人合作提高了工作效率，减少了工作量；
2. 相互监督督促，弥补了个人不足；
3. 通过交流学习，提高了编程水平；
*缺点：
1. 在合作完成项目时，偶尔会有理解分歧以及意见分歧从而消耗了一定时间
2. 由于都是Java和git新手，在分工方面没有明确的准则，都是个人想到什么做什么，比较杂乱；