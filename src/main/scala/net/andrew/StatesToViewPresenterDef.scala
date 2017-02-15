package net.andrew

import io.udash._
import net.andrew.views._

class StatesToViewPresenterDef extends ViewPresenterRegistry[RoutingState] {
  def matchStateToResolver(state: RoutingState): ViewPresenter[_ <: RoutingState] = state match {
    case RootState => RootViewPresenter
    case IndexState => IndexViewPresenter
    case BindingDemoState(urlArg) => BindingDemoViewPresenter(urlArg)
    case DemoStylesState => DemoStylesViewPresenter
    case _ => ErrorViewPresenter
  }
}