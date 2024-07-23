//
//  DisplayInfoNameSystem.swift
//  iosApp
//
//  Created by kenjimaeda on 23/07/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ItemsPlatform: Identifiable {
	let id = UUID()
	let description: String
	let value: String
	
}

struct DisplayInfoNameSystem: View {
	let plataform = Platform()
	var items: [ItemsPlatform] {
		return [
			ItemsPlatform(description: "Model device", value: plataform.deviceModel),
		  ItemsPlatform(description: "System Name",value: plataform.osName),
		  ItemsPlatform(description: "System Version", value: plataform.osVersion),
			ItemsPlatform(description: "Density", value: "\(Int(plataform.density))")
		]
	}
   
	
	 
    var body: some View {
			VStack(alignment: .leading){
				  Text("About System")
					.fontWeight(.bold)
					.font(.system(size: 20))
					.padding(EdgeInsets(top: 0, leading: 13, bottom: 0, trailing: 0))
 				List(items,id: \.id) { item in
					RowItemPlataform(item: item)
					.listRowInsets(EdgeInsets(top: 0, leading: 0, bottom: 10, trailing: 0))				}
	
			}
			.navigationBarTitleDisplayMode(.inline)
			.scrollContentBackground(.hidden)
		
			
     }
	

}



#Preview {
    DisplayInfoNameSystem()
}
