
线程声明周期：

   新建 ------> 就绪 ------> 阻塞 <------> 运行 ------> 死亡
          ↓        <------------------>               ↓
       start()              ↓                    run()/error/exception
                     <-失去CPU执行权                             
                      获得CPU执行权->    
                      
                      
                      
    