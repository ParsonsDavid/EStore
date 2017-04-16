package Strategy;

/**
 * Created by David on 16/04/2017.
 */
public class Context {
        private Strategy strategy;

        public Context(Strategy strategy){
            this.strategy = strategy;
        }

        public double executeStrategy(double price){
            return strategy.doOperation(price);
        }
    }

